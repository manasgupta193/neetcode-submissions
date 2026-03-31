class MedianFinder {
    private PriorityQueue<Integer> small; // Max-heap for lower half
    private PriorityQueue<Integer> large; // Min-heap for upper half

    public MedianFinder() {
        // Max-heap: Collections.reverseOrder()
        small = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap: default
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. Add to small (max-heap)
        small.offer(num);

        // 2. Balancing step: the largest of small must move to large
        large.offer(small.poll());

        // 3. Maintain size property: small can have at most 1 more than large
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }
}