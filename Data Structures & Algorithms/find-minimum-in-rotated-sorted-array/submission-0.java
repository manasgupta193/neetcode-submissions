class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // The min is in the right half, mid cannot be the min
                left = mid + 1;
            } else {
                // The min is in the left half, and mid could be the min
                right = mid;
            }
        }
        // left and right will converge to the minimum element
        return nums[left];
    }
}
