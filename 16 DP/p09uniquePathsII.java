import java.util.Arrays;

class Solution {
    private int findPaths_memo(int[][] dp, int[][] obstacleGrid, int i, int j) {
        if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) {
            return 0; // Out of bounds
        }
        
        if (i == 0 && j == 0) {
            return 1; // Base case: reached starting point
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j]; // Return already computed value
        }
        
        int up = findPaths_memo(dp, obstacleGrid, i-1, j);   // Move from top
        int left = findPaths_memo(dp, obstacleGrid, i, j-1); // Move from left
        
        return dp[i][j] = up + left;
    }

    private int findPaths_tab(int[][] obstacleGrid) {
        // Create a dp array with extra row and column for easier boundary management
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];

        // Set starting point if it's not an obstacle
        dp[1][1] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        // Fill the dp table
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // Skip the starting cell
                if (i == 1 && j == 1) continue;

                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0; // No paths through an obstacle
                } else {
                    // Paths from top + paths from left
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        // Return number of paths to bottom-right corner
        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length-1 + 1];
        
        for(int i=0; i<obstacleGrid.length; i++){
            Arrays.fill(dp[i], -1);
        }

        // return findPaths_memo(dp, obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1);
        return findPaths_tab(obstacleGrid);
    }
}


