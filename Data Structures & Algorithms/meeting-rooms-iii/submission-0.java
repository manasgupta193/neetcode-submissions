class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // 1. Sort meetings by original start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Room management
        PriorityQueue<Integer> unusedRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) unusedRooms.offer(i);

        // Stores [endTime, roomIndex]
        PriorityQueue<long[]> usedRooms = new PriorityQueue<>((a, b) -> 
            a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long duration = meeting[1] - meeting[0];

            // 3. Free up rooms that finished before this meeting starts
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                unusedRooms.offer((int) usedRooms.poll()[1]);
            }

            if (!unusedRooms.isEmpty()) {
                // Case A: A room is available immediately
                int room = unusedRooms.poll();
                usedRooms.offer(new long[]{start + duration, room});
                count[room]++;
            } else {
                // Case B: Delay - Wait for the earliest room to open
                long[] earliest = usedRooms.poll();
                long delayedStart = earliest[0];
                int room = (int) earliest[1];
                usedRooms.offer(new long[]{delayedStart + duration, room});
                count[room]++;
            }
        }

        // 4. Find the room with the maximum count
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > count[maxIndex]) maxIndex = i;
        }

        return maxIndex;
    }
}