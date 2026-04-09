class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSoFar = nums[0], currentMax = 0;
        int minSoFar = nums[0], currentMin = 0;
        
        for (int x : nums) {
            // Standard Kadane for Max
            currentMax = Math.max(x, currentMax + x);
            maxSoFar = Math.max(maxSoFar, currentMax);
            
            // Standard Kadane for Min
            currentMin = Math.min(x, currentMin + x);
            minSoFar = Math.min(minSoFar, currentMin);
            
            totalSum += x;
        }
        
        // If all elements are negative, maxSoFar is the answer 
        // (prevents returning 0 from totalSum - minSoFar)
        if (maxSoFar < 0) return maxSoFar;
        
        return Math.max(maxSoFar, totalSum - minSoFar);
    }
}