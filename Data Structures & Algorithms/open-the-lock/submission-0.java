class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        if (dead.contains("0000")) return -1;
        
        queue.offer("0000");
        visited.add("0000");
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) return level;
                
                for (String next : getNeighbors(curr)) {
                    if (!dead.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    private List<String> getNeighbors(String s) {
        List<String> res = new ArrayList<>();
        char[] ca = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char original = ca[i];
            
            // Turn Up
            ca[i] = (char)((original - '0' + 1) % 10 + '0');
            res.add(new String(ca));
            
            // Turn Down
            ca[i] = (char)((original - '0' + 9) % 10 + '0');
            res.add(new String(ca));
            
            ca[i] = original; // Backtrack
        }
        return res;
    }
}