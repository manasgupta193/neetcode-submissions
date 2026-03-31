class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Start from the rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            // Case 1: Current digit is less than 9
            if (digits[i] < 9) {
                digits[i]++;
                // No more carries needed, return early
                return digits;
            }
            
            // Case 2: Current digit is 9
            digits[i] = 0;
        }
        
        // Case 3: The "All Nines" case (e.g., 999 -> 000)
        // If we reach here, it means there is still a carry of 1.
        // We need a new array like [1, 0, 0, 0]
        int[] result = new int[n + 1];
        result[0] = 1; 
        // Note: result[1...n] are already 0 by default in Java
        return result;
    }
}