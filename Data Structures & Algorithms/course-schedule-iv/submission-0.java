class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // reachable[i][j] means course i is a prerequisite of course j
        boolean[][] reachable = new boolean[numCourses][numCourses];
        
        for (int[] p : prerequisites) {
            reachable[p[0]][p[1]] = true;
        }
        
        // Floyd-Warshall: Try every intermediate node 'k'
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    // If i can reach k AND k can reach j, then i can reach j
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }
        
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(reachable[q[0]][q[1]]);
        }
        return res;
    }
}