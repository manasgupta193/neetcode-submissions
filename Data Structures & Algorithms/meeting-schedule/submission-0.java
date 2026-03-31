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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return true;

        // 1. Sort intervals by start time using a Comparator
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // 2. Scan and compare end time of current with start time of next
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i + 1);
            
            // If current meeting ends after the next one starts, it's a conflict
            if (current.end > next.start) {
                return false;
            }
        }

        return true;
    }
}
