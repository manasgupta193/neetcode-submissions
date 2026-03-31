class Solution {
    public int splitArray(int[] nums, int k) {
        long left = 0;
        long right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                // Trial sum 'mid' is feasible, try to minimize further
                right = mid;
            } else {
                // 'mid' is too small, need a larger sum
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private boolean canSplit(int[] nums, int m, long maxSum) {
        int count = 1;
        long currentSum = 0;
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                if (count > m) return false;
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}