class Solution {
    // Standard phone mapping
    private static final String[] MAPPING = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, String digits, int index) {
        // Base Case: if current string length matches digits length
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        // Get letters for the current digit
        String letters = MAPPING[digits.charAt(index) - '0'];
        
        for (char c : letters.toCharArray()) {
            sb.append(c);                      // Choose
            backtrack(result, sb, digits, index + 1); // Explore next digit
            sb.deleteCharAt(sb.length() - 1);  // Backtrack (Un-choose)
        }
    }
}