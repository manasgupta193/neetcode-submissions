class Solution {
    public long minEnd(int n, int x) {
        // We need n-1 more elements after the first element (x)
        long target = n - 1;
        long result = x;
        
        int targetBit = 0;
        // We check every bit position (up to 64 for long)
        for (int i = 0; i < 64 && (target >> targetBit) > 0; i++) {
            // Check if the i-th bit of x is 0
            if (((result >> i) & 1) == 0) {
                // If the target has a bit at targetBit, set it in result at position i
                if (((target >> targetBit) & 1) == 1) {
                    result |= (1L << i);
                }
                targetBit++;
            }
        }
        
        return result;
    }
}