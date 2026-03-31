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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // 1. Dummy Head (Sentinel)
        // Eliminates the edge case where the "Head" of the list changes.
        // We treat the Dummy as the "tail of the previous group" for the first iteration.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;
        ListNode curr = head;

        // 2. The Main Loop
        while (curr != null) {
            // A. Check if we have k nodes left
            ListNode groupEnd = curr;
            // Walk k-1 steps to find the end of the group
            for (int i = 1; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }

            // If groupEnd is null, we have fewer than k nodes. We are done.
            if (groupEnd == null) break;

            // B. Secure the boundaries
            ListNode groupStart = curr;
            ListNode nextGroupStart = groupEnd.next;

            // C. Sever the connection to the rest of the list (Optional, but cleaner logic)
            groupEnd.next = null;

            // D. Reverse the isolated group
            // Helper returns the new head (which was groupEnd)
            reverse(groupStart);

            // E. Wiring (The Surgery)
            // 1. The previous group should point to the NEW head (old end)
            prevGroupTail.next = groupEnd;
            
            // 2. The NEW tail (old start) should point to the next group
            groupStart.next = nextGroupStart;

            // F. Advance Pointers
            // The "tail" of the group we just processed is 'groupStart'
            prevGroupTail = groupStart;
            curr = nextGroupStart;
        }

        return dummy.next;
    }

    // Standard O(N) Reversal
    private void reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
