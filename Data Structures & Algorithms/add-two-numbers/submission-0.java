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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode result = null;
        ListNode ptr3 = null;
        int carry = 0;
        while(ptr1!=null || ptr2!=null) {
            int firstVal = ptr1!=null ? ptr1.val : 0;
            int secondVal = ptr2!=null ? ptr2.val : 0;
            int sum = carry + firstVal + secondVal;
            carry = sum / 10;
            if(null == ptr3) {
                result = ptr3 = new ListNode(sum%10);
            } else {
                ptr3.next = new ListNode(sum%10);
                ptr3 = ptr3.next;
            }
            if(ptr1!=null) ptr1 = ptr1.next;
            if(ptr2!=null) ptr2 = ptr2.next;
        }
        if(carry!=0)
            ptr3.next = new ListNode(carry);
        return result;
    }
}
