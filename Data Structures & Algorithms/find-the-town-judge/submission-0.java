class Solution {
    public int findJudge(int n, int[][] trust) {
        // A judge needs at least n-1 trust relationships to exist
        if (trust.length < n - 1) return -1;

        int[] netTrust = new int[n + 1];

        for (int[] t : trust) {
            netTrust[t[0]]--; // Person trusts someone: -1
            netTrust[t[1]]++; // Person is trusted: +1
        }

        for (int i = 1; i <= n; i++) {
            if (netTrust[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}