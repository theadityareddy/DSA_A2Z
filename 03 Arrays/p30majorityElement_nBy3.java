// Function to find all elements that appear more than n/3 times in the array
// This uses the Extended Boyer-Moore Majority Vote Algorithm
//
// Explanation:
// At most, there can be only two elements that appear more than ⌊n/3⌋ times.
// This algorithm works in two phases:
// 1. Candidate Selection: Pick up to 2 candidates that could potentially be the majority elements.
// 2. Validation: Count the actual frequency of those candidates to ensure they occur more than n/3 times.
//
// Dry Run Example:
// Input: [3, 2, 3]
// Phase 1:
//   el1 = 3, cnt1 = 1
//   2 != 3 => el2 = 2, cnt2 = 1
//   3 == el1 => cnt1++
// Phase 2 (Validation):
//   Count 3 → 2 times
//   Count 2 → 1 time
// n = 3 → n/3 = 1 → floor(n/3) + 1 = 2
// 3 appears >= 2 → Add to result
// 2 appears < 2 → Ignore
//
// Output: [3]

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        // Initialize counters for two potential majority elements
        int cnt1 = 0, cnt2 = 0;

        // Initialize placeholders for the two potential candidates
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        // Phase 1: Find two potential majority candidates using Extended Boyer-Moore Voting Algorithm
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && nums[i] != el2) {
                // Assign new candidate to el1 if cnt1 is zero and it's not the same as el2
                cnt1 = 1;
                el1 = nums[i];
            } else if (cnt2 == 0 && nums[i] != el1) {
                // Assign new candidate to el2 if cnt2 is zero and it's not the same as el1
                cnt2 = 1;
                el2 = nums[i];
            } else if (nums[i] == el1) {
                // If current number matches el1, increment cnt1
                cnt1++;
            } else if (nums[i] == el2) {
                // If current number matches el2, increment cnt2
                cnt2++;
            } else {
                // If current number matches neither, decrement both counters
                cnt1--;
                cnt2--;
            }
        }

        // Phase 2: Count actual occurrences of the two candidates
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == el1) cnt1++;
            if (num == el2) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        int threshold = n / 3 + 1;  // More than floor(n/3) times

        // Add valid candidates to the result if they appear more than n/3 times
        if (cnt1 >= threshold) result.add(el1);
        if (cnt2 >= threshold && el2 != el1) result.add(el2); // Avoid duplicates

        return result;
    }
}
