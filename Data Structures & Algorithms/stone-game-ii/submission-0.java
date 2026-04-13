class Solution {
    private int[][] memo;
    private int[] suffixSum;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        memo = new int[n][n + 1];
        suffixSum = new int[n];
        
        // Fill suffixSum: suffixSum[i] = total stones from i to n-1
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return solve(0, 1, piles);
    }

    private int solve(int i, int m, int[] piles) {
        int n = piles.length;
        
        // Base case: if we can take all remaining piles
        if (i + 2 * m >= n) {
            return suffixSum[i];
        }
        
        if (memo[i][m] != 0) return memo[i][m];

        int minOpponentStones = Integer.MAX_VALUE;

        // Try taking X piles, where 1 <= X <= 2M
        for (int x = 1; x <= 2 * m; x++) {
            // The opponent will start from i + x with a new M = max(m, x)
            // We want to minimize the stones the opponent gets
            minOpponentStones = Math.min(minOpponentStones, solve(i + x, Math.max(m, x), piles));
        }

        // Alice's score = Total stones left - Min stones opponent can get
        memo[i][m] = suffixSum[i] - minOpponentStones;
        return memo[i][m];
    }
}