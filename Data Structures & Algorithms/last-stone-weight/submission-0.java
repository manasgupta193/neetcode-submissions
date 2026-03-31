class Solution {
    public int lastStoneWeight(int[] stones) {
        // 1. Initialize Max-Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // 2. Add all stones to the heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        // 3. Smash stones until 1 or 0 remain
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // Heaviest
            int stone2 = maxHeap.poll(); // Second heaviest
            
            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }
        
        // 4. Return result
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}