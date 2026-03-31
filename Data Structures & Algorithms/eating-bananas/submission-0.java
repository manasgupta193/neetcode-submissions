class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int p : piles) {
            right = Math.max(right, p);
        }

        // 2. Binary Search on the Answer Space
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                // If we can finish at 'mid', we might be able to finish slower.
                // Try left side. Include 'mid' because it is a valid answer.
                right = mid;
            } else {
                // If we cannot finish, we must go faster.
                // 'mid' is invalid, so skip it.
                left = mid + 1;
            }
        }

        // left == right is the smallest valid k
        return left;
    }

    // Predicate Function
    private boolean canFinish(int[] piles, int h, int speed) {
        long hoursNeeded = 0; // Use long to prevent overflow
        for (int p : piles) {
            // Integer Ceiling Division: (a + b - 1) / b
            hoursNeeded += (p + speed - 1) / speed;
        }
        return hoursNeeded <= h;
    }
}
