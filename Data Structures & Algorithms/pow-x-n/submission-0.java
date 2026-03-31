class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1;
        double currentProduct = x;
        
        while (N > 0) {
            // If the current bit of N is 1, multiply the result
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct; // Square the base
            N /= 2; // Move to the next bit
        }
        return result;
    }
}