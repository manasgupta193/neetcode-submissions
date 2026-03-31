class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        
        // We don't need to jump if we are already at the last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest reachable point seen so far
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we have finished the current jump's range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // If the new end already covers the destination, we are done
                if (currentEnd >= nums.length - 1) break;
            }
        }
        return jumps;
    }
}