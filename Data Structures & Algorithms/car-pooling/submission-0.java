class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // The problem constraints state the max distance is 1000
        int[] timeline = new int[1001];
        
        // Step 1: Record all pick-ups and drop-offs
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            
            timeline[start] += numPassengers;
            timeline[end] -= numPassengers;
        }
        
        // Step 2: Traverse the timeline and check current capacity
        int currentPassengers = 0;
        for (int change : timeline) {
            currentPassengers += change;
            
            // If at any point we exceed capacity, return false
            if (currentPassengers > capacity) {
                return false;
            }
        }
        
        return true;
    }
}