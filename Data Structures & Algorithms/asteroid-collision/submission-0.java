class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            // Flag to track if the current asteroid survived
            boolean exploded = false;

            // Collision only happens if:
            // 1. Stack top is moving RIGHT (+)
            // 2. Current asteroid is moving LEFT (-)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int topSize = stack.peek();
                int currentSize = Math.abs(ast);

                if (topSize < currentSize) {
                    // Current eats the top; top explodes, continue checking
                    stack.pop();
                    continue;
                } else if (topSize == currentSize) {
                    // Both explode
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    // Top eats the current; current explodes
                    exploded = true;
                    break;
                }
            }

            if (!exploded) {
                stack.push(ast);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}