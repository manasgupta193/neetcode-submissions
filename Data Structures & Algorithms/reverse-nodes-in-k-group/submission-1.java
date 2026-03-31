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

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy, nxt = dummy, prev = dummy;
        int count = 0;

        // Count total nodes in the list
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // Loop while there are at least k nodes left to reverse
        while (count >= k) {
            curr = prev.next; // Start of the group to be reversed
            nxt = curr.next;  // The node to be moved
            
            // Standard "Move to Front" reversal within k-group
            for (int i = 1; i < k; i++) {
                curr.next = nxt.next;
                nxt.next = prev.next;
                prev.next = nxt;
                nxt = curr.next;
            }
            
            prev = curr; // Move prev to the end of the reversed group
            count -= k;
        }

        return dummy.next;
    }
}