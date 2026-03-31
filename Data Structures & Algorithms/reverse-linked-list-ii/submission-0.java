/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        // 1. Create a dummy node to handle edge cases (like reversing from head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        // 2. Move 'pre' to the node immediately before the segment starts
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 3. 'start' is the first node of the segment to be reversed
        ListNode start = pre.next;
        // 4. 'then' is the node that will be moved to the front in each iteration
        ListNode then = start.next;

        // 5. Reverse (right - left) times
        // 1 -> 2 -> 3 -> 4 -> 5, left=2, right=4
        // pre=1, start=2, then=3
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}