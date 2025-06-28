public class p13longestSubarrayWithSumK {

    // For POSITIVES only
    // Time Complexity - O(2n)
    public static int slidingWindowLongestSubarrayWithSumK(int[] a, int k) {
        int left = 0, right = 0; // Pointers defining the current window
        int sum = 0;             // Current window sum
        int maxLen = 0;          // Maximum length found so far

        // Expand the window by moving 'right'
        while (right < a.length) {
            sum += a[right]; // Include the current element in the window

            // Shrink the window from the left if the sum exceeds k
            while (sum > k && left <= right) {
                sum -= a[left]; // Remove the leftmost element
                left++;         // Move the left pointer forward
            }

            // If current window sum equals k, update maxLen
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move to the next element
            right++;
        }

        return maxLen; // Return the maximum subarray length found
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        int result = slidingWindowLongestSubarrayWithSumK(nums, k);
        System.out.println("Longest subarray length with sum " + k + ": " + result);
    }
}
