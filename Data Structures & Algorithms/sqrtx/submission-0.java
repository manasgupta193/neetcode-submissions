class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 2, right = x / 2;
        int ans = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Use long to prevent mid * mid overflow
            long num = (long) mid * mid;

            if (num == x) {
                return mid;
            } else if (num < x) {
                ans = mid; // Candidate found, try to find a larger one
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}