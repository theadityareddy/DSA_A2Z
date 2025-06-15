import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    // Optimal Approach
    public static int usingSetLongestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num); // Add all numbers to the set
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Only check for the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    // Better Approach
    public static int bySortLongestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // Step 1: Sort the array
        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        // Step 2: Traverse the sorted array
        for (int i = 1; i < nums.length; i++) {
            // Skip duplicates
            if (nums[i] == nums[i - 1]) continue;

            // If current number is consecutive
            if (nums[i] == nums[i - 1] + 1) {
                currentStreak++;
            } else {
                // Reset current streak
                longestStreak = Math.max(longestStreak, currentStreak);
                currentStreak = 1;
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}
