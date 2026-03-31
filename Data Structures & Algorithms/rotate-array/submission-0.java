class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // Handle k > n
        if (k == 0) return;

        reverse(nums, 0, n - 1);       // Reverse all
        reverse(nums, 0, k - 1);       // Reverse first k
        reverse(nums, k, n - 1);       // Reverse rest
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}