import java.util.*;

public class p14sameAs13ForNegetives {

    // For POSITIVES and NEGETIVES
    // Time Complexity : O(n x 1)  for unorderedMap
    // Time Complexity : O(n x logn) for orderedMap
    public static int longestSubarrayWithSumK(int[] a, long k) {
        // Map to store the first occurrence of each prefix sum
        Map<Long, Integer> preSumMap = new HashMap<>();

        long sum = 0;       // Cumulative prefix sum
        int maxLen = 0;     // Maximum length of subarray found

        for (int i = 0; i < a.length; i++) {
            sum += a[i];    // Update prefix sum

            // Case 1: If the entire subarray from index 0 to i sums to k
            if (sum == k) {
                maxLen = i + 1;
            }

            // Case 2: Check if there's a subarray ending at i with sum k
            long rem = sum - k;

            // If (sum - k) has been seen before, it means a subarray exists between that index and i
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // Store the first occurrence of this prefix sum
            // We do not update if it already exists to ensure the longest length
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;  // Return the length of the longest valid subarray
    }

    public static void main(String[] args) {
        // Sample input
        int[] nums = {10, 5, 2, 7, 1, 9};
        long k = 15;

        // Compute and print result
        int result = longestSubarrayWithSumK(nums, k);
        System.out.println("Longest subarray length with sum " + k + ": " + result);
    }
}
