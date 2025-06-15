class XORSolution {
    public int missingNumber(int[] nums) {
        // XOR all numbers — duplicates cancel out (a ^ a = 0), leaving the missing number
        int xor = 0;
        int n = nums.length;

        // XOR all indices from 0 to n-1 and all elements in the array
        for (int i = 0; i < n; i++) {
            xor ^= i;        // XOR with index
            xor ^= nums[i];  // XOR with element
        }

        // XOR with n (since loop only went till n-1)
        xor ^= n;

        // Final result is the missing number
        return xor;
    }
}

class ExpectedSumSolution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // Calculate the expected sum of numbers from 0 to n using the formula: n(n + 1) / 2
        int expectedSum = n * (n + 1) / 2;

        // Calculate the actual sum of the given array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // The difference is the missing number
        return expectedSum - actualSum;
    }
}

