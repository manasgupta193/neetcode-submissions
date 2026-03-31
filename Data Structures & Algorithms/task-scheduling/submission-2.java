class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. Count frequencies of each task
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        
        // 2. Sort to find the max frequency
        Arrays.sort(freq);
        int maxFreq = freq[25];
        
        // 3. Calculate the number of empty slots available
        int idleSlots = (maxFreq - 1) * n;
        
        // 4. Fill the slots with other tasks
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            idleSlots -= Math.min(maxFreq - 1, freq[i]);
        }
        
        // 5. Final calculation
        idleSlots = Math.max(0, idleSlots);
        return tasks.length + idleSlots;
    }
}