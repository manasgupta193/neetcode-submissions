class LFUCache {
    class Node {
        int key, val, freq;
        Node prev, next;
        Node(int k, int v) {
            this.key = k;
            this.val = v;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;
        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        Node removeTail() {
            if (size > 0) {
                Node node = tail.prev;
                removeNode(node);
                return node;
            }
            return null;
        }
    }

    private Map<Integer, Node> cache;
    private Map<Integer, DoublyLinkedList> freqMap;
    private int capacity, size, minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            if (size == capacity) {
                DoublyLinkedList minList = freqMap.get(minFreq);
                Node toDelete = minList.removeTail();
                cache.remove(toDelete.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            size++;
            minFreq = 1;
            freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.removeNode(node);
        
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }
        
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addNode(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */