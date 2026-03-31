class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // While the current temperature is warmer than the one at the top of the stack...
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // We've found the next warmer day for the day at the top of the stack
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            // Push the current day's index onto the stack
            stack.push(i);
        }

        return result;
    }
}