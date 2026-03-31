class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // prices array stores the min cost to reach each city
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // We can take AT MOST k stops, which means AT MOST k + 1 edges
        for (int i = 0; i <= k; i++) {
            // Create a copy to ensure we only use results from the PREVIOUS iteration
            int[] temp = Arrays.copyOf(prices, n);
            
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int price = flight[2];

                // If we can't reach city u yet, skip
                if (prices[u] == Integer.MAX_VALUE) continue;

                // Relax the edge: Can we get to v cheaper via u?
                if (prices[u] + price < temp[v]) {
                    temp[v] = prices[u] + price;
                }
            }
            // Move the calculated prices into our main array for the next stop/level
            prices = temp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}