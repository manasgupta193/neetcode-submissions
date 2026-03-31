class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        
        Map<Character, Integer> counts = new HashMap<>();
        for (char t : tasks) counts.put(t, counts.getOrDefault(t, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(counts.values());
        
        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1; // The window size
            
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll() - 1);
                }
                time++;
                if (pq.isEmpty() && temp.stream().allMatch(x -> x <= 0)) break;
            }
            
            for (int remaining : temp) {
                if (remaining > 0) pq.add(remaining);
            }
        }
        return time;
    }
}