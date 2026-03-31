/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) return 0;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        // Sort both arrays independently
        Arrays.sort(starts);
        Arrays.sort(ends);

        int usedRooms = 0;
        int endPtr = 0;

        // Iterate through the start times
        for (int startPtr = 0; startPtr < n; startPtr++) {
            // If a meeting starts before the earliest one ends, we need a new room
            if (starts[startPtr] < ends[endPtr]) {
                usedRooms++;
            } else {
                // Otherwise, a meeting ended, so we can reuse a room
                endPtr++;
            }
        }

        return usedRooms;
    }
}


