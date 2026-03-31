class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        // Build graph and calculate indegrees
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int pReq = pre[1];
            adj.get(pReq).add(course);
            indegree[course]++;
        }

        // Add all courses with no prerequisites to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;

            // "Unlock" dependent courses
            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If we processed all courses, return the order; otherwise, there's a cycle
        return (index == numCourses) ? order : new int[0];
    }
}