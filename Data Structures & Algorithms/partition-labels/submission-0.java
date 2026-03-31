class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndices = new int[26];
        // Pass 1: Record the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndices[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        // Pass 2: Partition based on the furthest last occurrence
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndices[s.charAt(i) - 'a']);
            
            // If current index reaches the furthest needed boundary
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}