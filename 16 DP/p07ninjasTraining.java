public class p07ninjasTraining {

    // Memoization (Top-Down) approach
    public static int ninjaTraining_memo(int day, int task, int[][] points, int[][] dp) {
        // Base case: if no more days left
        if (day == 0) {
            return 0;
        }

        // If this state has already been computed, return the stored value
        if (dp[day][task] != -1) {
            return dp[day][task];
        }

        int maxPoints = 0;

        // Try all previous tasks (task can't be same as the current task)
        for (int prevTask = 0; prevTask < points[0].length; prevTask++) {
            if (prevTask != task) {
                int take = points[day - 1][task] + ninjaTraining_memo(day - 1, prevTask, points, dp);
                maxPoints = Math.max(maxPoints, take); // Maximize the points
            }
        }

        return dp[day][task] = maxPoints; // Store the result
    }

    // Tabulation (Bottom-Up) approach
    public static int ninjaTraining_tab(int days, int tasks, int[][] points) {
        int[][] dp = new int[days + 1][tasks + 1]; // dp[day][task]

        // Initialize dp base cases (day 0)
        for (int i = 0; i <= days; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= tasks; j++) {
            dp[0][j] = 0;
        }

        // Build the dp table day by day
        for (int day = 1; day <= days; day++) {
            for (int currTask = 1; currTask <= tasks; currTask++) {
                for (int prevTask = 0; prevTask <= tasks; prevTask++) {
                    if (currTask != prevTask) { // Can't repeat same task
                        int take = points[day - 1][currTask - 1] + dp[day - 1][prevTask]; // Take points + prev day score
                        dp[day][currTask] = Math.max(dp[day][currTask], take); // Store max
                    }
                }
            }
        }

        // Find the max points from last day
        int maxPoints = 0;
        for (int task = 1; task <= tasks; task++) {
            maxPoints = Math.max(maxPoints, dp[days][task]);
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        int[][] points = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };

        int days = points.length;   // Total days
        int tasks = points[0].length; // Total tasks per day

        // Initialize dp array for memoization (fill with -1 initially)
        int[][] dp = new int[days + 1][tasks + 1];
        for (int i = 0; i <= days; i++) {
            for (int j = 0; j <= tasks; j++) {
                dp[i][j] = -1; // Initialize with -1 to signify uncomputed states
            }
        }

        // Using Memoization
        System.out.println("Memoization Answer: " + ninjaTraining_memo(days, tasks - 1, points, dp));

        // Using Tabulation
        System.out.println("Tabulation Answer: " + ninjaTraining_tab(days, tasks, points));
    }
}
