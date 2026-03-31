class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) {
            return 0;
        }

        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars by position (ascending)
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        int fleets = 0;
        double lastFleetTime = 0.0;

        // Iterate from the car closest to the target back to the last car
        for (int i = n - 1; i >= 0; i--) {
            double currentTime = (target - cars[i][0]) / cars[i][1];
            
            // If the current car takes longer to arrive than the last fleet, it forms a new fleet.
            // Note: If times are equal, they form a fleet, so we use >.
            if (currentTime > lastFleetTime) {
                fleets++;
                lastFleetTime = currentTime;
            }
        }
        
        return fleets;
    }
}
