class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0; // Need at least 3 bars to trap water
        }

        int left = 0;
        int right = n - 1;
        int totalWater = 0;

        int leftMax = 0;  // Max height encountered from left side so far
        int rightMax = 0; // Max height encountered from right side so far

        while (left < right) {
            // Determine which side's boundary is currently shorter
            if (height[left] < height[right]) {
                // The left bar is shorter, so its height (or leftMax) potentially limits water
                // for the current segment from the left.
                
                if (height[left] >= leftMax) {
                    // Current bar is taller than or equal to previous leftMax.
                    // It acts as a new highest left boundary, so no water is trapped *at this point*.
                    leftMax = height[left];
                } else {
                    // Current bar is shorter than leftMax. Water can be trapped above it.
                    // The water level is limited by the leftMax.
                    totalWater += leftMax - height[left];
                }
                left++; // Move left pointer to consider the next bar
            } else {
                // The right bar is shorter or equal to the left bar.
                // Its height (or rightMax) potentially limits water for the current segment from the right.
                
                if (height[right] >= rightMax) {
                    // Current bar is taller than or equal to previous rightMax.
                    // It acts as a new highest right boundary.
                    rightMax = height[right];
                } else {
                    // Current bar is shorter than rightMax. Water can be trapped above it.
                    // The water level is limited by the rightMax.
                    totalWater += rightMax - height[right];
                }
                right--; // Move right pointer to consider the next bar
            }
        }
        return totalWater;
    }
}