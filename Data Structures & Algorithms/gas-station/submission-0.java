class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0; // To check if a circuit is possible at all
        int currentSurplus = 0; // To find the starting point
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int netChange = gas[i] - cost[i];
            totalSurplus += netChange;
            currentSurplus += netChange;

            // If we run out of gas at station i
            if (currentSurplus < 0) {
                // Every station before i is a failed starting point.
                // Reset and try starting from the next station.
                startStation = i + 1;
                currentSurplus = 0;
            }
        }

        // If total gas is enough to cover total cost, startStation is valid.
        return (totalSurplus >= 0) ? startStation : -1;
    }
}