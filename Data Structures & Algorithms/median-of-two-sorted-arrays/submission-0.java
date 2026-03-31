class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        
        // This ensures enough elements on the left side
        int totalLeft = (m + n + 1) / 2;

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = totalLeft - cut1;

            // Handle edge cases (infinity for out of bounds)
            // L1 | R1
            // L2 | R2
            double l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            
            double l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // Check Validity
            if (l1 <= r2 && l2 <= r1) {
                // Correct partition found
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                // Too many elements from nums1. Move Left.
                high = cut1 - 1;
            } else {
                // l2 > r1. Too few elements from nums1. Move Right.
                low = cut1 + 1;
            }
        }

        return 0.0; // Should not reach here

    }
}
