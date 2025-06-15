import java.util.Arrays;

public class p08uniquePaths {
    
    private int findPaths_memo(int[][] dp, int i, int j) {
        if (i < 0 || j < 0) {
            return 0; // Out of bounds
        }
        
        if (i == 0 && j == 0) {
            return 1; // Base case: reached starting point
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j]; // Return already computed value
        }
        
        int up = findPaths_memo(dp, i - 1, j);   // Move from top
        int left = findPaths_memo(dp, i, j - 1); // Move from left
        
        return dp[i][j] = up + left;
    }
    
    private int findPaths_tab(int m, int n) {
        // Create a dp array with extra row and column for easier boundary management
        int[][] dp = new int[m + 1][n + 1];

        // Set starting point
        dp[1][1] = 1;

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Skip the starting cell
                if (i == 1 && j == 1) continue;

                // Paths from top + paths from left
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return number of paths to bottom-right corner
        return dp[m][n];
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        // return findPaths_memo(dp, m - 1, n - 1);
        return findPaths_tab(m, n);
    }
}
