/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1. Clone & Interweave
        // A -> B -> C  ==>  A -> A' -> B -> B' -> C -> C'
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // 2. Wire Random Pointers
        // A'.random = A.random.next (which is the copy of A.random)
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // curr.next is the copy node
                curr.next.random = curr.random.next; 
            }
            // Move to next original node (skip copy)
            curr = curr.next.next;
        }

        // 3. Unweave (Restore original list and extract copy)
        // A -> A' -> B -> B'
        // A -> B   AND   A' -> B'
        curr = head;
        Node newHead = head.next;
        Node copyCurr = newHead;

        while (curr != null) {
            // Restore Original: A -> B
            curr.next = curr.next.next;
            
            // Restore Copy: A' -> B'
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            
            // Advance
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return newHead;
    }
}
