class Solution {
    public int tribonacci(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        
        int a = 0, b = 1, c = 1;
        int d = 0;
        
        for (int i = 3; i <= n; i++) {
            d = a + b + c; // Current value
            a = b;         // Shift pointers
            b = c;
            c = d;
        }
        
        return c;
    }
}