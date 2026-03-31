class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 1. Sort to make identifying duplicates easy
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // If already used in current path, skip
            if (used[i]) continue;

            // CRITICAL PRUNING STEP:
            // If current number is same as previous, AND previous wasn't used,
            // it means we already explored this 'value' at this position.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            tempList.add(nums[i]);
            
            backtrack(res, tempList, nums, used);
            
            // Backtrack
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}