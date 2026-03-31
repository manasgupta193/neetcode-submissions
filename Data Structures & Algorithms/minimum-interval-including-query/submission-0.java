class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;

        // 1. Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Store queries with original indices to maintain result order
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. Min-Heap stores: [length, end_time]
        // We want the smallest length at the top.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[m];
        int intervalIdx = 0;

        for (int i = 0; i < m; i++) {
            int queryVal = sortedQueries[i][0];
            int queryOriginalIdx = sortedQueries[i][1];

            // Add all intervals that start <= current query
            while (intervalIdx < n && intervals[intervalIdx][0] <= queryVal) {
                int start = intervals[intervalIdx][0];
                int end = intervals[intervalIdx][1];
                minHeap.offer(new int[]{end - start + 1, end});
                intervalIdx++;
            }

            // Remove intervals from top that end before current query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < queryVal) {
                minHeap.poll();
            }

            // Smallest length is at the top of the heap
            result[queryOriginalIdx] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }

        return result;
    }
}