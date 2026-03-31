class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int totalCost = 0;
        int edgesUsed = 0;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        while (edgesUsed < n) {
            int currNode = -1;
            int currDist = Integer.MAX_VALUE;

            // Find the node with the minimum distance to the current tree
            for (int i = 0; i < n; i++) {
                if (!visited[i] && minDist[i] < currDist) {
                    currDist = minDist[i];
                    currNode = i;
                }
            }

            totalCost += currDist;
            visited[currNode] = true;
            edgesUsed++;

            // Update distances to neighbors
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    int dist = Math.abs(points[currNode][0] - points[nextNode][0]) + 
                               Math.abs(points[currNode][1] - points[nextNode][1]);
                    if (dist < minDist[nextNode]) {
                        minDist[nextNode] = dist;
                    }
                }
            }
        }
        return totalCost;
    }
}