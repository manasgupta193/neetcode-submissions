class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        // Use two pointers, starting at the widest possible container.
        while (left < right) {
            // Calculate the current height (limited by the shorter line).
            int currentHeight = Math.min(height[left], height[right]);
            // Calculate the current width.
            int currentWidth = right - left;
            
            // Calculate the area for the current container.
            int currentArea = currentHeight * currentWidth;
            
            // Update the maximum area found so far.
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer that points to the shorter line inward.
            // This is the greedy step that ensures we might find a taller container.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--; // If height[right] <= height[left], move right inward.
            }
        }
        
        return maxArea;
    }
}