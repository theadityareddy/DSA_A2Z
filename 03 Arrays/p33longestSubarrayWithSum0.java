import java.util.HashMap;

public class p33longestSubarrayWithSum0 {
    int maxLen(int A[], int n) {
        // HashMap to store the first occurrence of each prefix sum
        HashMap<Integer, Integer> mpp = new HashMap<>();

        int maxi = 0; // Variable to keep track of the maximum length of subarray with sum = 0
        int sum = 0;  // Variable to store the prefix sum while iterating

        for (int i = 0; i < n; i++) {
            sum += A[i]; // Update the running sum

            if (sum == 0) {
                // If sum becomes 0, then the subarray from index 0 to i has sum 0
                maxi = i + 1;
            } else {
                // If the same sum has been seen before
                if (mpp.get(sum) != null) {
                    // Subarray between previous index + 1 and current index has sum = 0
                    // Update maximum length
                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {
                    // Store the first occurrence of the sum
                    mpp.put(sum, i);
                }
            }
        }

        return maxi; // Return the maximum length found
    }
}
