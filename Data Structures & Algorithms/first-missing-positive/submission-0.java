class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // 1. Place each number in its correct "seat"
        // Correct seat for number 'x' is index 'x - 1'
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the value at its target index
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        // 2. Scan the array to find the first "seat" occupied by the wrong "person"
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // 3. If all seats 1 to n are correct, the missing one is n + 1
        return n + 1;
    }
}