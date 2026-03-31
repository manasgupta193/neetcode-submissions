class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number.
        // HashMap: num -> frequency
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create "buckets" where index is frequency and value is a list of numbers with that frequency.
        // The maximum possible frequency is nums.length.
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Populate the buckets with numbers based on their frequencies.
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(num);
        }

        // Step 3: Collect the top k frequent elements by iterating buckets from highest frequency down.
        List<Integer> result = new ArrayList<>();
        // Iterate from the highest possible frequency (nums.length) down to 1.
        for (int i = buckets.length - 1; i >= 1 && result.size() < k; i--) {
            // Add all numbers from the current frequency bucket to the result list.
            for (int num : buckets[i]) {
                result.add(num);
                // If we have collected k elements, we can stop early.
                if (result.size() == k) {
                    break;
                }
            }
        }

        // Convert List<Integer> to int[] as required by the problem signature.
        int[] finalResult = new int[k];
        for (int i = 0; i < k; i++) {
            finalResult[i] = result.get(i);
        }

        return finalResult;
    }
}