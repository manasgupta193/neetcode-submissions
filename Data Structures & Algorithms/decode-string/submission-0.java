class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        StringBuilder currentRes = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Handle multi-digit numbers (e.g., 100[a])
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // Save current state
                countStack.push(k);
                resStack.push(currentRes);
                // Reset for the new nested level
                currentRes = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // Finish nested level
                StringBuilder decodedString = currentRes;
                currentRes = resStack.pop();
                int repeatTimes = countStack.pop();
                
                while (repeatTimes-- > 0) {
                    currentRes.append(decodedString);
                }
            } else {
                currentRes.append(c);
            }
        }
        return currentRes.toString();
    }
}