import java.util.HashMap;

class HashSolution {
    public int singleNumber_hash(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find the number that appears only once
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }

        // Should never reach here for valid input
        return -1;
    }
}

class XORSolution {
    public int singleNumber_xor(int[] nums) {
        int result = 0;

        // XOR all numbers — duplicates cancel out (a ^ a = 0)
        for (int num : nums) {
            result ^= num;
        }

        // The unique number remains
        return result;
    }
}
