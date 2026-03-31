class StockSpanner {
    // Stack stores int[] where [0] is price and [1] is the span of that price
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int currentSpan = 1;
        
        // While the stack is not empty and the top price is <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // "Collapse" the previous mountain into the current span
            currentSpan += stack.pop()[1];
        }
        
        stack.push(new int[]{price, currentSpan});
        return currentSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */