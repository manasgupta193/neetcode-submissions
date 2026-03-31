class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int prev2 = 1; // dp[i-2]
        int prev1 = 1; // dp[i-1]

        for (int i = 2; i <= s.length(); i++) {
            int current = 0;
            // Valid single digit
            if (s.charAt(i - 1) != '0') current += prev1;
            
            // Valid two digits
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) current += prev2;

            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}