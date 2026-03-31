class MyHashMap {
    private static class Node {
        int key, value;
        Node next;
        Node(int key, int value) { this.key = key; this.value = value; }
    }

    private final int BUCKETS = 10007; // Prime number to reduce collisions
    private Node[] table;

    public MyHashMap() {
        table = new Node[BUCKETS];
    }

    private int hash(int key) {
        return key % BUCKETS;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        if (table[idx] == null) {
            table[idx] = new Node(-1, -1); // Dummy head for easier deletion
        }
        Node prev = find(table[idx], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int idx = hash(key);
        if (table[idx] == null) return -1;
        Node prev = find(table[idx], key);
        return prev.next == null ? -1 : prev.next.value;
    }

    public void remove(int key) {
        int idx = hash(key);
        if (table[idx] == null) return;
        Node prev = find(table[idx], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    // Returns the node BEFORE the target key for easy removal
    private Node find(Node bucket, int key) {
        Node curr = bucket, prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}