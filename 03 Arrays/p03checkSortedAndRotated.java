class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        // Loop through the array to count the number of "drops"
        for(int i = 0; i < n; i++) {
            // If current element is greater than next (with wrap-around using modulo)
            if(nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // A sorted and rotated array can have at most one "drop"
        return count <= 1;
    }
}