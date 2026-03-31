class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // 1. Sort the people by weight
        Arrays.sort(people);
        
        int left = 0;                  // Lightest person
        int right = people.length - 1; // Heaviest person
        int boats = 0;
        
        while (left <= right) {
            // If the lightest and heaviest can share a boat
            if (people[left] + people[right] <= limit) {
                left++; // Lightest person gets on
            }
            
            // The heaviest person ALWAYS gets on a boat in this step.
            // If they couldn't share with 'left', they go alone.
            right--; 
            boats++;
        }
        
        return boats;
    }
}