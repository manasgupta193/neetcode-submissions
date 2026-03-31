class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // Step 1: Add all numbers to a HashSet for O(1) average time lookups.
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Step 2: Iterate through the set to find potential sequence starts.
        for (int num : numSet) {
            // Check if the current number `num` is the potential start of a sequence.
            // A number `num` is a start if `num - 1` is NOT present in the set.
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Extend the sequence by checking for `currentNum + 1`, `currentNum + 2`, etc.
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the overall longest streak found so far.
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}