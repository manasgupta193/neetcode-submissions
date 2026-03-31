class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Kick 0 to the low boundary
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 stays in the middle
                mid++;
            } else { // nums[mid] == 2
                // Throw 2 to the high boundary
                swap(nums, mid, high);
                high--;
                // Don't increment mid here because the swapped element 
                // from 'high' needs to be inspected!
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}