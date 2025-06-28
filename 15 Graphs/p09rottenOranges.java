import java.util.*;

class TUF {
    // Custom class to hold row, column, and time taken
    static class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) 
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int totalOranges = 0;

        // Step 1: Add all initially rotten oranges to queue
        // and count all non-empty cells (fresh + rotten)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) totalOranges++;

                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, 0));
                }
            }
        }

        if (totalOranges == 0) return 0;

        int dx[] = {0, 0, 1, -1}; // delta x
        int dy[] = {1, -1, 0, 0}; // delta y
        int rottenCount = 0;
        int maxTime = 0;

        // Step 2: BFS traversal
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int r = current.row;
            int c = current.col;
            int time = current.time;

            rottenCount++;
            maxTime = Math.max(maxTime, time); // track latest time

            // Check 4-directionally
            for (int i = 0; i < 4; i++) {
                int newR = r + dx[i];
                int newC = c + dy[i];

                // Skip if out of bounds or already rotten/empty
                if (newR < 0 || newC < 0 || newR >= rows || newC >= cols || grid[newR][newC] != 1)
                    continue;

                // Mark orange as rotten and add to queue
                grid[newR][newC] = 2;
                queue.offer(new Pair(newR, newC, time + 1));
            }
        }

        // Step 3: If all oranges are rotten, return time; else return -1
        return rottenCount == totalOranges ? maxTime : -1;
    }

    public static void main(String args[]) {
        int[][] arr = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required: " + rotting);
    }
}
