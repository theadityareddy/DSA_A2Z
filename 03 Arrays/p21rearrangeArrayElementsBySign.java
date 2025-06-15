class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Pointers for positive (even) and negative (odd) indices
        int pos = 0, neg = 1;
        int n = nums.length;
        int[] res = new int[n]; // Result array

        // Traverse input array
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res[pos] = nums[i]; // Place positive at even index
                pos += 2;
            } else {
                res[neg] = nums[i]; // Place negative at odd index
                neg += 2;
            }
        }

        return res; // Return result
    }
}
