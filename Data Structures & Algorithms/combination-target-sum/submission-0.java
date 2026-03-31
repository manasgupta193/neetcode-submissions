class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting allows us to stop early if a number is already too large
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, 
                           int[] nums, int remain, int start) {
        if (remain < 0) return; 
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Optimization: if the current number is greater than the remaining 
            // target, all subsequent numbers (since sorted) will also be too large.
            if (nums[i] > remain) break;

            tempList.add(nums[i]);
            // Notice we pass 'i' as the start index, not 'i + 1', to allow reuse
            backtrack(result, tempList, nums, remain - nums[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}