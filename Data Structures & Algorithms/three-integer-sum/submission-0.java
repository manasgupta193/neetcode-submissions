class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result; // Not enough elements to form a triplet.
        }

        // Step 1: Sort the array. This is crucial for both efficiency and handling duplicates.
        Arrays.sort(nums);

        // Step 2: Iterate through the array to fix the first element (nums[i]).
        // The loop goes up to nums.length - 2 because we need at least two elements (left, right) after i.
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for nums[i].
            // If i is not the first element AND nums[i] is the same as the previous element,
            // then we've already considered triplets with this value as the first element.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; 
            }

            // Step 3: Use two pointers (left and right) for the remaining part of the array.
            // This is essentially the Two Sum II problem.
            int left = i + 1;
            int right = nums.length - 1;
            // The target sum for the two pointers is 0 - nums[i].
            int targetForTwoPointers = -nums[i];

            while (left < right) {
                int currentSum = nums[left] + nums[right];

                if (currentSum == targetForTwoPointers) {
                    // Found a triplet that sums to 0. Add it to the result list.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Step 4: Skip duplicates for left and right pointers.
                    // Move left pointer past any duplicates.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Move right pointer past any duplicates.
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers inward for the next unique pair.
                    left++;
                    right--;
                } else if (currentSum < targetForTwoPointers) {
                    // Current sum is too small, need a larger value from the left side.
                    left++;
                } else { // currentSum > targetForTwoPointers
                    // Current sum is too large, need a smaller value from the right side.
                    right--;
                }
            }
        }

        return result;
    }
}