import java.util.Arrays;
import java.util.HashMap;

// Time Complexity - O(n)
// Hashing Approach (better when you need to return the index of the 2 sums)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i< nums.length; i++){
            int remainder = target - nums[i];
            
            if(map.containsKey(remainder)){
                return new int[] {map.get(remainder), i};
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}

// O(n logn)
// 2-Pointer Approach (better when you want to return if 2sum is possible or not [ture/false]) + (when array is sorted)
class TwoPointer {
    public static String twoSum(int n, int []arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return "YES";
            } else if (sum < target) left++;
            else right--;
        }
        return "NO";
    }

    public static void main(String args[]) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        String ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 1: " + ans);

    }
} 