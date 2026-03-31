class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort to bring duplicates together
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset to our result
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            // 2. Pruning: skip duplicates
            // If the current element is the same as the previous one
            // AND we are not at the 'start' of this recursion level, skip it.
            if (i > start && nums[i] == nums[i - 1]) continue;

            tempList.add(nums[i]);
            // Move to the next index
            backtrack(result, tempList, nums, i + 1);
            // Backtrack
            tempList.remove(tempList.size() - 1);
        }
    }
}