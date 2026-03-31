class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort to bring duplicates together
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Every state in the tree is a valid subset
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            // If the current element is a duplicate of the previous element 
            // in the SAME level of recursion, skip it to avoid duplicate subsets.
            if (i > start && nums[i] == nums[i - 1]) continue;

            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}