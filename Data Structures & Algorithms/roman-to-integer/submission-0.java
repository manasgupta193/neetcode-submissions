class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int current = getValue(s.charAt(i));
            
            // If not at the last character, check the next one
            if (i < n - 1) {
                int next = getValue(s.charAt(i + 1));
                if (current < next) {
                    total -= current; // Subtraction rule
                } else {
                    total += current;
                }
            } else {
                total += current; // Last character is always added
            }
        }
        return total;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}