class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            // According to constraints, nums.length is at least 1,
            // but good practice to handle.
            // If empty, max sum is 0 or -infinity depending on definition.
            // Given constraints, this won't be hit.
            return 0; 
        }

        // max_so_far stores the maximum sum found anywhere in the array
        int max_so_far = nums[0]; 
        
        // current_max stores the maximum sum of a subarray ending at the current position
        int current_max = nums[0]; 

        // Iterate from the second element
        for (int i = 1; i < nums.length; i++) {
            // Option 1: Start a new subarray with nums[i]
            // Option 2: Extend the previous subarray by adding nums[i]
            // We choose the one that gives a larger sum ending at current position.
            current_max = Math.max(nums[i], current_max + nums[i]);
            
            // Update the overall maximum sum found
            max_so_far = Math.max(max_so_far, current_max);
        }

        return max_so_far;
    }
}