import java.util.ArrayList;

public class p09unionOfTwoSortedArrays {
    public static void main(String args[]) {
        int n = 10, m = 7;
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};

        ArrayList<Integer> Union = FindUnion(arr1, arr2, n, m);

        // Print the union result
        System.out.println("Union of arr1 and arr2 is:");
        for (int val : Union){
            System.out.print(val + " ");
        }
    }

    // Function to find the union of two sorted arrays
    private static ArrayList<Integer> FindUnion(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays simultaneously
        while (i < n && j < m) {
            // Skip duplicates in arr1
            while (i > 0 && i < n && arr1[i] == arr1[i - 1]) i++;
            // Skip duplicates in arr2
            while (j > 0 && j < m && arr2[j] == arr2[j - 1]) j++;

            // Ensure indices are still in bounds after skipping duplicates
            if (i < n && j < m) {
                if (arr1[i] < arr2[j]) {
                    ans.add(arr1[i]);
                    i++;
                } else if (arr1[i] > arr2[j]) {
                    ans.add(arr2[j]);
                    j++;
                } else {
                    // Common element, add only once
                    ans.add(arr1[i]);
                    i++;
                    j++;
                }
            }
        }

        // Add remaining unique elements from arr1
        while (i < n) {
            if (i == 0 || arr1[i] != arr1[i - 1]) {
                ans.add(arr1[i]);
            }
            i++;
        }

        // Add remaining unique elements from arr2
        while (j < m) {
            if (j == 0 || arr2[j] != arr2[j - 1]) {
                ans.add(arr2[j]);
            }
            j++;
        }

        return ans;
    }
}
