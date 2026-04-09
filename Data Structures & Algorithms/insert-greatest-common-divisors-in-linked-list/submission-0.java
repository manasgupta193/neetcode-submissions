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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            if(next != null) {
                ListNode newNode = new ListNode(gcd(cur.val, next.val));
                newNode.next = next;
                cur.next = newNode;
            }
            cur = next;
        }
        return dummy.next;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}