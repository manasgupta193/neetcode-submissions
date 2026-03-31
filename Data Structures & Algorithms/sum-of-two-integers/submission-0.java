class Solution {
    public int getSum(int a, int b) {
        // 'b' acts as our carry holder
        while (b != 0) {
            // 1. Find the bits where a carry will occur
            int carry = (a & b) << 1;
            
            // 2. Perform the addition without the carry
            a = a ^ b;
            
            // 3. Update 'b' to be the carry to add in the next iteration
            b = carry;
        }
        return a;
    }
}