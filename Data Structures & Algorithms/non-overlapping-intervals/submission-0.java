class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // 1. Sort by END time - O(N log N)
        // Why end time? Because the one that ends first leaves 
        // the most room for the next interval.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0; // Number of non-overlapping intervals we CAN keep
        int end = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            // If the current interval starts after or at the previous end
            if (interval[0] >= end) {
                count++;
                end = interval[1]; // Update the end to current interval's end
            }
        }

        // Result = Total - Max non-overlapping
        return intervals.length - count;
    }
}