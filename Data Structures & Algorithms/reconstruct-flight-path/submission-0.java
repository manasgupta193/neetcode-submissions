class Solution {
    // We use a PriorityQueue to automatically keep destinations sorted
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 1. Build the graph
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        // 2. Start DFS from JFK
        dfs("JFK");
        
        return result;
    }

    private void dfs(String airport) {
        PriorityQueue<String> destinations = adj.get(airport);
        
        // While there are flights available from this airport
        while (destinations != null && !destinations.isEmpty()) {
            // Take the lexicographically smallest flight and remove it (poll)
            String next = destinations.poll();
            dfs(next);
        }
        
        // Post-order: Add to the front of the list when we can't go further
        result.addFirst(airport);
    }
}