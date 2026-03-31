class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                // Take the element from the end and put it here
                nums[i] = nums[n - 1];
                // Reduce array size (effectively "removing" the end element)
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}