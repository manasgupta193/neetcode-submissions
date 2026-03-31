class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        // 1. Map frequencies
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;

        // 2. Max-Heap for available tasks
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) maxHeap.add(f);
        }

        int time = 0;
        // Queue stores [remaining_count, time_available_at]
        Queue<int[]> waitingRoom = new LinkedList<>();

        while (!maxHeap.isEmpty() || !waitingRoom.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;
                if (count > 0) {
                    waitingRoom.add(new int[]{count, time + n});
                }
            }

            // Check if any task in the waiting room has finished cooldown
            if (!waitingRoom.isEmpty() && waitingRoom.peek()[1] == time) {
                maxHeap.add(waitingRoom.poll()[0]);
            }
        }

        return time;
    }
}