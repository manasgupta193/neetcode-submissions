class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // row[j] is the value from the row above
                // row[j-1] is the value from the cell to the left
                row[j] = row[j] + row[j - 1];
            }
        }
        return row[n - 1];
    }
}