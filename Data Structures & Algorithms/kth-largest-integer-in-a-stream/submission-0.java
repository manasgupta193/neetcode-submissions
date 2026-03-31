class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(); // Default is a Min-Heap

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        
        // If heap exceeds size k, the smallest element is irrelevant
        // for the kth largest calculation.
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        
        // The root of the Min-Heap of size k is the kth largest element.
        return minHeap.peek();
    }
}