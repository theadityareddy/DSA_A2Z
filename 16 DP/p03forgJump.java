import java.util.*;

public class p03forgJump {

    // Memoization (Top-Down) approach
    private static int jump_memo(int i, int[] height, int[] dp) {
        if (i == 0) return 0; // Base case

        if (dp[i] != -1) return dp[i]; // Already computed

        int oneJump = Math.abs(height[i] - height[i-1]) + jump_memo(i-1, height, dp);

        int twoJump = Integer.MAX_VALUE;
        if (i > 1) {
            twoJump = Math.abs(height[i] - height[i-2]) + jump_memo(i-2, height, dp);
        }

        return dp[i] = Math.min(oneJump, twoJump);
    }

    // Tabulation (Bottom-Up) approach
    private static int jump_tab(int[] height, int[] dp) {
        int n = height.length;
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int oneJump = Math.abs(height[i] - height[i-1]) + dp[i-1];

            int twoJump = Integer.MAX_VALUE;
            if (i > 1) {
                twoJump = Math.abs(height[i] - height[i-2]) + dp[i-2];
            }

            dp[i] = Math.min(oneJump, twoJump);
        }

        return dp[n-1];
    }

    // Space Optimized approach
    private static int jump_space_optimized(int[] height) {
        int n = height.length;
        
        int prev1 = 0; // dp[i-1]
        int prev2 = 0; // dp[i-2]

        for (int i = 1; i < n; i++) {
            int oneJump = Math.abs(height[i] - height[i-1]) + prev1;
            
            int twoJump = Integer.MAX_VALUE;
            if (i > 1) {
                twoJump = Math.abs(height[i] - height[i-2]) + prev2;
            }

            int curr = Math.min(oneJump, twoJump); // Current minimum energy
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1; // Final answer
    }

    public static void main(String args[]) {
        int height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;

        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        System.out.println("Tabulation Answer: " + jump_tab(height, dp));
        System.out.println("Space Optimized Answer: " + jump_space_optimized(height));
    }
}
