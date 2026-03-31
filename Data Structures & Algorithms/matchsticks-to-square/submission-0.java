class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;
        
        int sum = 0;
        for (int m : matchsticks) sum += m;
        if (sum % 4 != 0) return false;
        
        int target = sum / 4;
        // Sort descending to optimize: try large sticks first
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        return backtrack(matchsticks, new int[4], 0, target);
    }

    private boolean backtrack(int[] sticks, int[] sides, int index, int target) {
        if (index == sticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target;
        }

        for (int i = 0; i < 4; i++) {
            // Optimization: If current side + stick > target, skip
            if (sides[i] + sticks[index] > target) continue;
            
            // Optimization: If this side has the same length as a previous side, 
            // we've already tried this combination.
            int j = i - 1;
            while (j >= 0) {
                if (sides[j] == sides[i]) break;
                j--;
            }
            if (j != -1) continue;

            sides[i] += sticks[index];
            if (backtrack(sticks, sides, index + 1, target)) return true;
            sides[i] -= sticks[index];
        }
        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}