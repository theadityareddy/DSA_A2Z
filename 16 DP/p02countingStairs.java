// leetcode

import java.util.Arrays;

class Solution {
    public int climb_memo(int n, int[] dp){ // Memoization
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];

        int oneStep = climb_memo(n-1, dp);
        int twoStep = climb_memo(n-2, dp);

        return dp[n] = oneStep + twoStep;
    }

    

    public int climb_tab_On(int n) { // Tabulation - O(n)
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        int oneStep = 0;
        int twoStep = 0;

        dp[0] = 1;
        for(int i=1; i<=n; i++){
            oneStep = dp[i-1];
            if(i>1) {
                twoStep = dp[i-2];
            }
            dp[i] = oneStep + twoStep;
        }

        return dp[n];
    }

    public int climb_tab_O1(int n) { // Tabulation - O(1)
        if (n == 0 || n == 1) return 1;
    
        int prev1 = 1; // dp[i-1]
        int prev2 = 1; // dp[i-2]
        int curr = 0;
    
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
    
        return prev1;
    }

    public int climbStairs(int n) {
        return climb_tab_O1(n);
    } 
}