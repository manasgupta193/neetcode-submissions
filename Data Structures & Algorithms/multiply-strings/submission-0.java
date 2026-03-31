class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int n1 = num1.length(), n2 = num2.length();
        int[] pos = new int[n1 + n2];
        
        // 1. Multiply digits and place them in the correct position
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                
                // Add to existing value at p2 (might contain previous carry)
                int sum = mul + pos[p2];
                
                pos[p2] = sum % 10;   // Single digit
                pos[p1] += sum / 10;  // Carry to p1
            }
        }
        
        // 2. Convert array to String
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // Skip leading zeros
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}