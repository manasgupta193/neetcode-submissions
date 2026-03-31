class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        // 'insertIndex' is our "slow" pointer
        int insertIndex = 1; 
        
        // 'i' is our "fast" pointer
        for (int i = 1; i < nums.length; i++) {
            // If current element is different from the previous one, it's unique
            if (nums[i] != nums[i - 1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        
        return insertIndex;
    }
}