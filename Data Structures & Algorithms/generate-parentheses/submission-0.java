class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: If the string is of the required length, it must be valid.
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Rule 1: Add an open parenthesis if we haven't used all N yet.
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Rule 2: Add a closing parenthesis if it balances a preceding open one.
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}