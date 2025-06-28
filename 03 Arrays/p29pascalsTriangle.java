// Every element has a formula (row-1)C(col-1)

import java.util.ArrayList;
import java.util.List;

class Solution {

    // Helper function to generate a specific row of Pascal's Triangle (1-indexed)
    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // First element is always 1

        // Use the formula: C(n, k) = C(n, k-1) * (n - k + 1) / k
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);  // Compute next binomial coefficient
            ans = ans / col;
            ansRow.add((int)ans);     // Cast long to int and add to row
        }
        return ansRow;
    }

    // Main function to generate the first numRows of Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        // Loop through each row index from 1 to numRows (inclusive)
        for (int row = 1; row <= numRows; row++) {
            ans.add(generateRow(row)); // Add the generated row to the result
        }

        return ans; // Return the full triangle
    }
}
