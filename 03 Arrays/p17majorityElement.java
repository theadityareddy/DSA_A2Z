public class p17majorityElement {

    /**
     * Function to find the majority element using Boyer-Moore Voting Algorithm.
     *
     * The idea is to maintain a count and a candidate for majority.
     * - If count becomes 0, we choose the current number as the new candidate.
     * - If the current number is the same as candidate, we increment count.
     * - Otherwise, we decrement count.
     *
     * Why this works:
     * - Since the majority element appears more than n/2 times, it cannot be fully cancelled out
     *   by other elements. The final candidate will always be the majority element.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Example Dry Run:
     * Input: [2, 2, 1, 1, 1, 2, 2]
     *
     * i=0: num=2 → count=0 → candidate=2, count=1
     * i=1: num=2 → same as candidate → count=2
     * i=2: num=1 → different → count=1
     * i=3: num=1 → different → count=0
     * i=4: num=1 → count=0 → candidate=1, count=1
     * i=5: num=2 → different → count=0
     * i=6: num=2 → count=0 → candidate=2, count=1
     * Final candidate = 2 → Majority element
     * 
     * Simpler version is just using HashMap to track count and find majority
     * 
     */

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;

        for (int num : nums) {
            // When count drops to 0, choose the current number as a new candidate
            if (count == 0) {
                candidate = num;
            }

            // Adjust count: +1 if num == candidate, else -1
            count += (num == candidate) ? 1 : -1;
        }

        // Since the problem guarantees a majority element, return the candidate
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = majorityElement(nums);
        System.out.println("Majority Element: " + result);
    }
}
