class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // 1. Combine position and speed, then sort by position DESC
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            // Calculate time to reach target
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Sort by position descending (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();
        for (double[] car : cars) {
            double currentTime = car[1];
            
            // If the stack is empty or the current car takes MORE time 
            // than the fleet in front, it starts a new fleet.
            if (stack.isEmpty() || currentTime > stack.peek()) {
                stack.push(currentTime);
            }
            // If currentTime <= stack.peek(), this car catches up 
            // and becomes part of the existing fleet (do nothing).
        }

        return stack.size();
    }
}