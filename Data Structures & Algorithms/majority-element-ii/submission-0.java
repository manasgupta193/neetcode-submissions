class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 1. Initialize two potential candidates and their counters
        Integer candidate1 = null, candidate2 = null;
        int count1 = 0, count2 = 0;

        // First Pass: Find potential candidates
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                // If we find a third distinct element, "cancel" all three
                count1--;
                count2--;
            }
        }

        // Second Pass: Verify the candidates (Boyer-Moore doesn't guarantee they exist)
        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) count1++;
            if (candidate2 != null && num == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }
}