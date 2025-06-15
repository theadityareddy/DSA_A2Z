public class p18n19maximumSubarraySumKadans {
    /**
     * Function to find the maximum subarray sum using Kadane's Algorithm.
     *
     * Idea:
     * - Track current subarray sum (`currSum`), and global max (`maxSum`).
     * - If current sum becomes negative, reset it to 0 (start fresh).
     * - This is because if a number is -ve, then it won't add value to the subarray 
     *   instead it'll just drag down the sum
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Example Dry Run:
     * Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
     *
     * Step-by-step:
     * i=0: currSum = -2 → maxSum = -2
     * i=1: currSum = max(1, -2+1) = 1 → maxSum = 1
     * i=2: currSum = max(-3, 1-3) = -2 → maxSum = 1
     * i=3: currSum = max(4, -2+4) = 4 → maxSum = 4
     * i=4: currSum = 4 + (-1) = 3 → maxSum = 4
     * i=5: currSum = 3 + 2 = 5 → maxSum = 5
     * i=6: currSum = 5 + 1 = 6 → maxSum = 6
     * i=7: currSum = 6 - 5 = 1 → maxSum = 6
     * i=8: currSum = 1 + 4 = 5 → maxSum = 6
     * Final Result = 6
     */

    public static int maxSubArray(int[] nums) {
        int currSum = nums[0]; // Initialize with the first element
        int maxSum = nums[0];  // Max sum so far

        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous subarray or start a new one
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
    
}
