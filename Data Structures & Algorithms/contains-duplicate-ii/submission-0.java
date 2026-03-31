class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // If the set already contains the number, it's within distance k
            if (window.contains(nums[i])) return true;
            
            window.add(nums[i]);
            
            // Keep the set size restricted to k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}