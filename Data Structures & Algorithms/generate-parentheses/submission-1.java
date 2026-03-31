class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int open, int close, int n) {
        // Base Case: The string has reached the maximum length 2n
        if (sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        }

        // Rule 1: Add an opening bracket if we have more left
        if (open < n) {
            sb.append('(');
            backtrack(result, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }

        // Rule 2: Add a closing bracket if it won't violate balance
        if (close < open) {
            sb.append(')');
            backtrack(result, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
    }
}