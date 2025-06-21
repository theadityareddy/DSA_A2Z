import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        // Map to store frequency of prefix sums (prefixSum, count)
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        // base case: prefix sum of 0 has frequency 1
        // This helps handle subarrays that directly start from index 0
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            sum += num; // Update running prefix sum

            // check if there's a prefix sum such that: sum - prefix = k → prefix = sum - k
            // if yes, it means there's a subarray ending here with sum = k
            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }

            // update the frequency of the current prefix sum in map
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
