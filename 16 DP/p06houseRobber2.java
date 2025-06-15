// leetcode

class Solution {

    // Helper function to calculate max amount from 'start' to 'end-1'
    private int robUtil(int[] nums, int start, int end){
        if(start == end) return 0; // No houses to rob

        int dp[] = new int[nums.length];
        dp[start] = nums[start]; // Base case: first house

        for (int i = start + 1; i < end; i++){
            int rob = nums[i]; // Rob current house
            if (i - 2 >= start){
                rob += dp[i-2]; // Add loot from two houses back
            }
            int wontRob = dp[i-1]; // Skip current house

            dp[i] = Math.max(rob, wontRob); // Choose max of robbing or skipping
        }

        return dp[end-1]; // Max loot till 'end-1' house
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // Only one house, rob it

        // Case 1: Rob from house 0 to n-2 (exclude last house)
        int rob1 = robUtil(nums, 0, n-1);
        // Case 2: Rob from house 1 to n-1 (exclude first house)
        int rob2 = robUtil(nums, 1, n);

        return Math.max(rob1, rob2); // Return max of both cases
    }
}
