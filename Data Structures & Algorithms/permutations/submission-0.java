class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // Base case: current permutation is complete
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Because nums are distinct, we check if we've already used this element
            if (tempList.contains(nums[i])) continue;

            tempList.add(nums[i]);            // Choose
            backtrack(result, tempList, nums); // Explore
            tempList.remove(tempList.size() - 1); // Un-choose (Backtrack)
        }
    }
}