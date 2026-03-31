class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;
        
        int target = sum / k;
        Arrays.sort(nums);
        // Reverse to try larger numbers first (pruning)
        reverse(nums);
        
        return backtrack(nums, new int[k], 0, target);
    }

    private boolean backtrack(int[] nums, int[] subsets, int index, int target) {
        if (index == nums.length) return true;

        for (int i = 0; i < subsets.length; i++) {
            if (subsets[i] + nums[index] <= target) {
                subsets[i] += nums[index];
                if (backtrack(nums, subsets, index + 1, target)) return true;
                subsets[i] -= nums[index];
            }
            // Optimization: If the bucket is empty and we couldn't fit the number,
            // no need to try this number in other empty buckets.
            if (subsets[i] == 0) break;
        }
        return false;
    }
    
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}