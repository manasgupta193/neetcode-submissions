class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE; // Start with a very high minPrice
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            // Update minPrice to be the lowest price seen so far
            minPrice = Math.min(minPrice, prices[i]);
            
            // Calculate potential profit if we buy at minPrice and sell today
            // And update maxProfit if this is a new maximum
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }
}