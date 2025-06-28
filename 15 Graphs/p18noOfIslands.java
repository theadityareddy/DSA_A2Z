import java.util.*;

// Custom Pair class to hold coordinates
class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    // BFS traversal to mark all land cells in the current island
    private void bfs(int startRow, int startCol, int[][] visited, char[][] grid) {
        visited[startRow][startCol] = 1;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(startRow, startCol));

        int numRows = grid.length;
        int numCols = grid[0].length;

        // Traverse until the queue is empty
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int row = current.row;
            int col = current.col;

            // Check all 8 possible directions (including diagonals)
            for (int dRow = -1; dRow <= 1; dRow++) {
                for (int dCol = -1; dCol <= 1; dCol++) {
                    int newRow = row + dRow;
                    int newCol = col + dCol;

                    // Check boundaries and whether it's an unvisited land cell
                    if (newRow >= 0 && newRow < numRows &&
                        newCol >= 0 && newCol < numCols &&
                        grid[newRow][newCol] == '1' &&
                        visited[newRow][newCol] == 0) {

                        visited[newRow][newCol] = 1;
                        queue.add(new Coordinate(newRow, newCol));
                    }
                }
            }
        }
    }

    // Main function to count the number of islands
    public int numIslands(char[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int[][] visited = new int[numRows][numCols];
        int islandCount = 0;

        // Traverse the entire grid
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                // If cell is unvisited land, start BFS and increment island count
                if (visited[row][col] == 0 && grid[row][col] == '1') {
                    islandCount++;
                    bfs(row, col, visited, grid);
                }
            }
        }

        return islandCount;
    }

    public static void main(String[] args) {
        char[][] grid = {
            { '0', '1', '1', '1', '0', '0', '1' },
            { '0', '0', '1', '1', '0', '1', '1' }
        };

        Solution solution = new Solution();
        System.out.println("Number of islands: " + solution.numIslands(grid));
    }
}
