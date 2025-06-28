import java.util.*;

class Solution {

    // Directions for Up, Down, Left, Right
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> uniqueShapes = new HashSet<>();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<String> shape = new ArrayList<>();
                    dfs(grid, visited, i, j, i, j, shape);
                    uniqueShapes.add(String.join(",", shape));
                }
            }
        }

        return uniqueShapes.size();
    }

    // DFS with relative positioning
    private void dfs(int[][] grid, boolean[][] visited, int baseRow, int baseCol, int row, int col, List<String> shape) {
        int rows = grid.length, cols = grid[0].length;

        // Boundary and visit check
        if (row < 0 || col < 0 || row >= rows || col >= cols ||
            grid[row][col] == 0 || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        // Store relative position to the base cell
        shape.add((row - baseRow) + "_" + (col - baseCol));

        for (int[] dir : directions) {
            dfs(grid, visited, baseRow, baseCol, row + dir[0], col + dir[1], shape);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}
        };
        System.out.println("Distinct Islands: " + sol.numDistinctIslands(grid)); // Output: 1
    }
}
