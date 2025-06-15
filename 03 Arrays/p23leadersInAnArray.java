/*
 * Question: Leaders in an Array
 *
 * An element is a leader if it is greater than or equal to all the elements to its right side.
 * The rightmost element is always a leader.
 *
 * Write a program to print all leader elements in the array.
 *
 * Example:
 * Input:  [16, 17, 4, 3, 5, 2]
 * Output: [17, 5, 2]
 *
 * Explanation:
 * - 17 is greater than 4, 3, 5, 2
 * - 5 is greater than 2
 * - 2 is the last element, hence a leader
 */

import java.util.*;

public class p23leadersInAnArray {
    
    // Function to find leaders from right
    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int maxFromRight = arr[n - 1];

        res.add(maxFromRight); // Last element is always a leader

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                res.add(arr[i]);
                maxFromRight = arr[i]; // Update max
            }
        }

        // Reverse the result to maintain original order
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find and print leaders
        List<Integer> leaders = findLeaders(arr);
        for (int num : leaders) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
