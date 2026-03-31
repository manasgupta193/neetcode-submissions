class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 + op2);
            } else if (token.equals("-")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 - op2);
            } else if (token.equals("*")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 * op2);
            } else if (token.equals("/")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 / op2);
            } else {
                // It's a number
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}