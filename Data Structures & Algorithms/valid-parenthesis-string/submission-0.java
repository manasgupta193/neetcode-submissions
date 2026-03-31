class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Treat * as ')' or ""
        int maxOpen = 0; // Treat * as '('

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // '*'
                minOpen--; // as ')'
                maxOpen++; // as '('
            }

            // If maxOpen < 0, even with all '*' as '(', we have too many ')'
            if (maxOpen < 0) return false;
            
            // minOpen can't be negative; if it is, we reset (meaning we used '*' as "" instead)
            minOpen = Math.max(minOpen, 0);
        }

        // We can only return true if it's possible to have exactly 0 open '('
        return minOpen == 0;
    }
}