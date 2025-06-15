import java.util.Arrays;

class Solution {
    private int findMinSum_memo(int[][] grid, int[][] dp, int i, int j){
        // Out of bounds
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }

        // Starting cell
        if(i == 0 && j == 0){
            return grid[0][0];
        }

        // Return already computed result
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Recursive calls: move up and left
        int goUp = findMinSum_memo(grid, dp, i-1, j);
        int goLeft = findMinSum_memo(grid, dp, i, j-1);

        // Store and return minimum path sum
        return dp[i][j] = grid[i][j] + Math.min(goUp, goLeft);
    }

    private int findMinSum_tab(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Starting point
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    // First row: can only come from the left
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                } else if (j == 0) {
                    // First column: can only come from the top
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                } else {
                    // Rest of the cells: min of top or left cell
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Return the minimum sum to reach bottom-right
        return dp[m-1][n-1];
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        // return findMinSum_memo(grid, dp, grid.length-1, grid[0].length-1);
        return findMinSum_tab(grid);
    }
}