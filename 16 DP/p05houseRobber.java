// leetcode

import java.util.Arrays;

class Solution {

    // Memoization (Top-Down) approach
    public int rob_memo(int[] nums, int n, int[] dp){
        if(n < 0) return 0; // Base case: no houses left

        if (dp[n] != -1) return dp[n]; // Return cached result

        // Rob current house + solve for n-2
        int rob = nums[n] + rob_memo(nums, n-2, dp);
        // Skip current house and solve for n-1
        int wontRob = rob_memo(nums, n-1, dp);

        return dp[n] = Math.max(rob, wontRob); // Store and return max
    }

    // Tabulation (Bottom-Up) approach
    public int rob_tab(int[] nums, int n, int[] dp) {
        dp[0] = nums[0]; // Base case: only first house

        for (int i = 1; i < n; i++) {
            int rob = nums[i]; // Rob current house
            if (i > 1){
                rob += dp[i-2]; // Add loot from two houses back
            }
            int wontRob = dp[i-1]; // Skip current house

            dp[i] = Math.max(rob, wontRob); // Choose best option
        }

        return dp[n-1]; // Max loot up to last house
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1); // Initialize DP array for memoization

        // return rob_memo(nums, nums.length-1, dp); // Using memoization

        return rob_tab(nums, nums.length, dp); // Using tabulation
    }
}
