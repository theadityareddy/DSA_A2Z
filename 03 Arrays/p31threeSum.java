/**
     * This method finds all unique triplets in the array that sum up to zero.
     *
     * Approach:
     * 1. Sort the array to allow use of the two-pointer technique and to handle duplicates easily.
     * 2. Fix one element (nums[i]) and use two pointers (j and k) to find two other elements
     *    such that nums[i] + nums[j] + nums[k] == 0.
     * 3. Skip duplicate values for all three elements to avoid adding duplicate triplets.
     * 4. Continue this process for all possible values of i.
     *
     * Time Complexity: O(n^2), where n is the length of the input array.
     * Space Complexity: O(1), ignoring the space used for the output list.
     *
     * Example:
     * Input:  [-1, 0, 1, 2, -1, -4]
     * Output: [[-1, -1, 2], [-1, 0, 1]]
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // Step 1: Sort the array to use two-pointer approach and handle duplicates
        Arrays.sort(nums);

        // Step 2: Traverse the array
        for (int i = 0; i < n; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Initialize two pointers
            int j = i + 1;
            int k = n - 1;

            // Step 3: Use two-pointer technique to find the pair
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++; // Move left pointer to right to increase sum
                } else if (sum > 0) {
                    k--; // Move right pointer to left to decrease sum
                } else {
                    // Found a valid triplet
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);

                    j++;
                    k--;

                    // Skip duplicates for the second and third numbers
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans;
    }
}
