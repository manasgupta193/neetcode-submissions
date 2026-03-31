class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for (int card : hand) counts.put(card, counts.getOrDefault(card, 0) + 1);

        while (!counts.isEmpty()) {
            int first = counts.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int currentCard = first + i;
                if (!counts.containsKey(currentCard)) return false;
                
                int count = counts.get(currentCard);
                if (count == 1) counts.remove(currentCard);
                else counts.put(currentCard, count - 1);
            }
        }
        return true;
    }
}