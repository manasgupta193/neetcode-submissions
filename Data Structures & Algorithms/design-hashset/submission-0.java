class MyHashSet {
    private static final int BUCKETS = 769; // A prime number to reduce collisions
    private LinkedList<Integer>[] parentFolder;

    public MyHashSet() {
        parentFolder = new LinkedList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            parentFolder[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % BUCKETS;
    }

    public void add(int key) {
        int index = hash(key);
        if (!parentFolder[index].contains(key)) {
            parentFolder[index].add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        // Using Integer object to ensure the correct remove(Object) method is called
        parentFolder[index].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = hash(key);
        return parentFolder[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */