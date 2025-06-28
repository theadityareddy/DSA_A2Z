import java.util.*;

public class p35mergeOverlappingIntervals {

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;

        // Step 1: Sort the intervals based on their start times
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> merged = new ArrayList<>();

        // Step 2: Process each interval
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Case 1: No overlap
            if (merged.isEmpty() || start > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[] {start, end});
            } 
            // Case 2: Overlap, merge with the last interval
            else {
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], end);
            }
        }

        // Convert the list to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] merged = merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
