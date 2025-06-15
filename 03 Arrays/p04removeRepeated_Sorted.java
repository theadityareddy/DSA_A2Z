class Solution {
    public int removeDuplicates(int[] nums) {
        // Handle empty array
        if (nums.length == 0) return 0;

        int j = 0; // Pointer to track position of last unique element

        // Start from the second element and compare with the last unique one
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;               // Move to next unique position
                nums[j] = nums[i]; // Place the next unique element
            }
        }

        // Return the count of unique elements
        return j + 1;
    }
}
