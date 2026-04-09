class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n < 2) return n;

        int maxLen = 1;
        int currentStreak = 0;

        for (int i = 1; i < n; i++) {
            // Compare current pair
            int comparison = Integer.compare(arr[i - 1], arr[i]);
            
            if (comparison == 0) {
                // Elements are equal, reset streak to 1
                currentStreak = 0;
            } else if (i == 1 || comparison != Integer.compare(arr[i - 2], arr[i - 1])) {
                // Trend flipped (or it's the first pair), increment streak
                currentStreak++;
            } else {
                // Trend stayed the same, reset to a 2-element streak (length 1 comparison)
                currentStreak = 1;
            }
            
            // Note: maxLen tracks elements, currentStreak tracks comparisons.
            // Elements = comparisons + 1
            maxLen = Math.max(maxLen, currentStreak + 1);
        }

        return maxLen;
    }
}