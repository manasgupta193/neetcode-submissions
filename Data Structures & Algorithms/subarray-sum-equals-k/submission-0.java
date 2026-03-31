class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        // Key: Prefix Sum, Value: How many times it has occurred
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Base case: A prefix sum of 0 has occurred once (empty subarray)
        prefixSumMap.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // If (currentSum - k) exists in the map, it means there are 
            // subarrays ending at the current index that sum to k.
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            // Update the map with the current prefix sum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}