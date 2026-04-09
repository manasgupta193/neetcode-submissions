class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 1. Check if a common divisor even exists
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // 2. The GCD string length must be the GCD of the two lengths
        int gcdLength = gcd(str1.length(), str2.length());
        
        // 3. The answer is the prefix of that length
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}