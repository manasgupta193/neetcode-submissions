class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Fill queues with initial indices
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Simulate the rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIdx = radiant.poll();
            int dIdx = dire.poll();

            // The senator with the smaller index acts first and bans the other
            if (rIdx < dIdx) {
                // Radiant wins this face-off, joins the next round
                radiant.offer(rIdx + n);
            } else {
                // Dire wins this face-off, joins the next round
                dire.offer(dIdx + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}