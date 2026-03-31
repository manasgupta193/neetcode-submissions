class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;     // End of valid nums1
        int p2 = n - 1;     // End of nums2
        int p = m + n - 1;  // End of nums1 capacity

        while (p2 >= 0) {
            // If p1 is exhausted, or nums2 element is larger, take from nums2
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        // Note: If p2 is exhausted first, remaining p1 elements are already in place.
    }
}