class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;     // Stores the maximum number of consecutive 1s found so far
        int currentCount = 0; // Stores the current streak of consecutive 1s

        for (int num : nums) {
            if (num == 1) {
                currentCount++;            // Increment current streak if 1 is found
                maxCount = Math.max(maxCount, currentCount); // Update max if needed
            } else {
                currentCount = 0;          // Reset current streak when a 0 is found
            }
        }

        return maxCount;
    }
}
