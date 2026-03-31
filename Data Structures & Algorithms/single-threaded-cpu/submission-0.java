class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] result = new int[n];
        
        // 1. Create a 3D array to keep track of [enqueueTime, processingTime, originalIndex]
        int[][] extendedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            extendedTasks[i][0] = tasks[i][0];
            extendedTasks[i][1] = tasks[i][1];
            extendedTasks[i][2] = i;
        }

        // 2. Sort tasks by enqueue time
        Arrays.sort(extendedTasks, (a, b) -> a[0] - b[0]);

        // 3. Min-Heap: Sort by processingTime, then by originalIndex
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        long currentTime = 0;
        int taskIdx = 0;
        int resIdx = 0;

        while (resIdx < n) {
            // If PQ is empty and no task has arrived yet, jump to the next task's arrival time
            if (pq.isEmpty() && currentTime < extendedTasks[taskIdx][0]) {
                currentTime = extendedTasks[taskIdx][0];
            }

            // Add all tasks that have arrived by 'currentTime' into the PQ
            while (taskIdx < n && extendedTasks[taskIdx][0] <= currentTime) {
                pq.offer(extendedTasks[taskIdx]);
                taskIdx++;
            }

            // Process the best task from the PQ
            int[] currentTask = pq.poll();
            result[resIdx++] = currentTask[2];
            currentTime += currentTask[1];
        }

        return result;
    }
}