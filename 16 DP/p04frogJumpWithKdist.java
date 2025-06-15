import java.util.*;

public class p04frogJumpWithKdist {

    // Memoization (Top-Down) approach
    private static int jumpK_memo(int i, int[] height, int[] dp, int k) {
        if (i == 0) return 0; // Base case: at starting stone

        if (dp[i] != -1) {
            return dp[i]; // Return already computed value
        }

        int minSteps = Integer.MAX_VALUE;

        // Try all jumps from 1 to k distance
        for (int j = 1; j <= k; j++) {
            int jump_k = Integer.MAX_VALUE;
            if ((i - j) >= 0) {
                jump_k = Math.abs(height[i] - height[i-j]) + jumpK_memo(i-j, height, dp, k);
                minSteps = Math.min(minSteps, jump_k); // Take minimum of all options
            }
        }

        return dp[i] = minSteps; // Store and return result
    }

    // Tabulation (Bottom-Up) approach
    private static int jumpK_tab(int[] height, int[] dp, int k) {
        int n = height.length;
        dp[0] = 0; // Starting stone, no energy needed

        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;

            // Try all jumps from 1 to k distance
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps; // Store minimum steps to reach stone i
        }

        return dp[n-1]; // Minimum energy to reach last stone
    }

    static int jumpK(int n, int[] height, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1); // Initialize DP array

        // Uncomment below to use Memoization
        // return jumpK_memo(n - 1, height, dp, k);

        return jumpK_tab(height, dp, k); // Using Tabulation
    }

    public static void main(String args[]) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int k = 2;
        System.out.println(jumpK(n, height, k)); // Print minimum energy to reach last stone
    }
}
