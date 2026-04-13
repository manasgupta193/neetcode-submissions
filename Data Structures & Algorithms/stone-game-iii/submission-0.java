class Solution {
    Integer[] memo;
    int n;

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        memo = new Integer[n];
        
        int score = solve(0, stoneValue);
        
        if (score > 0) return "Alice";
        if (score < 0) return "Bob";
        return "Tie";
    }

    private int solve(int i, int[] stoneValue) {
        if (i >= n) return 0;
        if (memo[i] != null) return memo[i];

        int res = Integer.MIN_VALUE;
        int currentTake = 0;

        // Try taking 1, 2, or 3 stones
        for (int k = 0; k < 3 && i + k < n; k++) {
            currentTake += stoneValue[i + k];
            // Alice's score = stones taken - best score opponent can get from the rest
            res = Math.max(res, currentTake - solve(i + k + 1, stoneValue));
        }

        return memo[i] = res;
    }
}