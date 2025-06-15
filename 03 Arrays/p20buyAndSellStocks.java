class Solution {
    public int maxProfit(int[] prices) {
        // Initialize minPrice to a very large number to ensure it gets updated
        int minPrice = Integer.MAX_VALUE;

        // maxProfit will store the maximum profit found so far
        int maxProfit = 0;

        // Loop through each price in the array
        for (int price : prices) {
            
            // If we find a new lower price, we consider it as a new buying day
            if (price < minPrice) {
                minPrice = price;
            } 
            // Otherwise, check if selling at current price gives better profit
            else {
                int profit = price - minPrice; // current potential profit
                maxProfit = Math.max(maxProfit, profit); // update max profit if better
            }
        }

        // Return the best profit found
        return maxProfit;
    }
}
