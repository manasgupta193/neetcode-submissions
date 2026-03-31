public class Solution {
    public int reverseBits(int n) {
        // Swap adjacent bits
        n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
        // Swap adjacent 2-bit blocks
        n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2);
        // Swap adjacent 4-bit blocks
        n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4);
        // Swap adjacent 8-bit blocks
        n = ((n & 0xFF00FF00) >>> 8) | ((n & 0x00FF00FF) << 8);
        // Swap adjacent 16-bit blocks
        n = (n >>> 16) | (n << 16);
        return n;
    }
}