class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // Map to keep track of mappings between opening and closing brackets
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket
            if (map.containsKey(c)) {
                // Get the top element of the stack. If empty, use a dummy value
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for the closing bracket doesn't match the top
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                // It's an opening bracket, push it onto the stack
                stack.push(c);
            }
        }

        // If the stack is empty, all brackets were matched
        return stack.isEmpty();
    }
}