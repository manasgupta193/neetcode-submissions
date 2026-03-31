class Solution {
    public int subsetXORSum(int[] nums) {
        int bitwiseOR = 0;
        for (int x : nums) {
            bitwiseOR |= x; // Find which bits are "active" at least once
        }
        // The sum is (OR of all elements) * 2^(n-1)
        return bitwiseOR << (nums.length - 1);
    }
}