class Solution {
    public int findDuplicate(int[] nums) {
        // 1. Guard Clause
        if (nums == null || nums.length < 2) return -1;

        // 2. Phase 1: Detect Cycle Intersection
        // We start at index 0.
        // Step mapping: index -> nums[index]
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];           // 1 step
            fast = nums[nums[fast]];     // 2 steps
        }

        // 3. Phase 2: Find Entry Point
        // Reset slow to start.
        slow = 0;
        
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
