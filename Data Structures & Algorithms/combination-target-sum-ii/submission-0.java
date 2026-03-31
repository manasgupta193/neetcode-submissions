class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting is crucial to group duplicates and prune the search space
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, 
                           int[] nums, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Optimization: fail fast if the number is already too large
            if (nums[i] > remain) break;

            // Skip duplicates: if we are at the same recursive level (i > start)
            // and the number is the same as the previous one, skip it.
            if (i > start && nums[i] == nums[i - 1]) continue;

            tempList.add(nums[i]);
            // Move to i + 1 because each element can be used only once
            backtrack(result, tempList, nums, remain - nums[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}