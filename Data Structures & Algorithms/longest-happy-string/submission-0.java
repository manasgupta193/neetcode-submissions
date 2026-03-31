class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Max-heap to store {character, count}, sorted by count descending
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) pq.offer(new int[]{'a', a});
        if (b > 0) pq.offer(new int[]{'b', b});
        if (c > 0) pq.offer(new int[]{'c', c});

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            int n = sb.length();

            // Check if adding 'first' would violate the "no three consecutive" rule
            if (n >= 2 && sb.charAt(n - 1) == first[0] && sb.charAt(n - 2) == first[0]) {
                if (pq.isEmpty()) break; // No other characters left to break the streak

                // Use the second most frequent character instead
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) pq.offer(second);

                // Put the 'first' character back to use in the next turn
                pq.offer(first);
            } else {
                // It's safe to use the most frequent character
                sb.append((char) first[0]);
                if (--first[1] > 0) pq.offer(first);
            }
        }

        return sb.toString();
    }
}