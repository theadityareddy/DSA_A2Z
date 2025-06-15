class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // Pointer to place the next non-zero element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap only if i and j are different to avoid unnecessary operations
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++; // Move j to the next position
            }
        }
    }
}
