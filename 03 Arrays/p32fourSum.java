import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length; // Size of the input array
        List<List<Integer>> ans = new ArrayList<>(); // To store the final list of unique quadruplets

        // Step 1: Sort the array to make it easier to use the two-pointer technique and handle duplicates
        Arrays.sort(nums);

        // Step 2: Fix the first element of the quadruplet
        for (int i = 0; i < n; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Step 3: Fix the second element of the quadruplet
            for (int j = i + 1; j < n; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Step 4: Use two pointers for the remaining two numbers
                int k = j + 1;     // Third element (left pointer)
                int l = n - 1;     // Fourth element (right pointer)

                // Step 5: Search for pairs (nums[k] + nums[l]) such that the sum of all 4 equals target
                while (k < l) {
                    // Use long to avoid integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        // Found a valid quadruplet
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);

                        // Move both pointers inward
                        k++;
                        l--;

                        // Skip duplicate third elements
                        while (k < l && nums[k] == nums[k - 1]) k++;

                        // Skip duplicate fourth elements
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        // If the sum is too small, move the left pointer to the right to increase the sum
                        k++;
                    } else {
                        // If the sum is too large, move the right pointer to the left to decrease the sum
                        l--;
                    }
                }
            }
        }

        return ans; // Return the list of all unique quadruplets
    }
}
