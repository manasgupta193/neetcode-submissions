class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        // Base case: combination is complete
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Optimization (Pruning): 
        // Only loop while there are enough numbers left to reach size k
        // The condition: (n - i + 1) >= (k - tempList.size())
        for (int i = start; i <= n - (k - tempList.size()) + 1; i++) {
            tempList.add(i); // Choose
            backtrack(result, tempList, i + 1, n, k); // Explore
            tempList.remove(tempList.size() - 1); // Backtrack
        }
    }
}