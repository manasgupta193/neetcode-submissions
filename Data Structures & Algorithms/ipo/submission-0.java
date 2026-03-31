class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        
        // Sort projects by required capital (ascending)
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);
        
        // Max-heap to store profits of affordable projects
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int currentIndex = 0;
        
        // We can pick up to k projects
        for (int i = 0; i < k; i++) {
            // Add all projects we can now afford into the max-heap
            while (currentIndex < n && projects[currentIndex][0] <= w) {
                maxProfitHeap.offer(projects[currentIndex][1]);
                currentIndex++;
            }
            
            // If we can't afford any new projects and the heap is empty, stop
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            
            // Greedily pick the project with the highest profit
            w += maxProfitHeap.poll();
        }
        
        return w;
    }
}