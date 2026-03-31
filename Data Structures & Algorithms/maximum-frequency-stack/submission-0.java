class FreqStack {
    // Maps element to its current frequency
    Map<Integer, Integer> freqMap;
    // Maps a frequency count to a stack of elements that have reached that frequency
    Map<Integer, Stack<Integer>> groupMap;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        groupMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        // 1. Update the frequency of the value
        int f = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, f);

        // 2. Update max frequency if necessary
        if (f > maxFreq) {
            maxFreq = f;
        }

        // 3. Add the value to the stack corresponding to its current frequency
        groupMap.computeIfAbsent(f, z -> new Stack<>()).push(val);
    }

    public int pop() {
        // 1. Get the most recent element from the highest frequency stack
        int val = groupMap.get(maxFreq).pop();

        // 2. Decrement the frequency in our counter
        freqMap.put(val, maxFreq - 1);

        // 3. If the highest frequency stack is now empty, move to the level below
        if (groupMap.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}