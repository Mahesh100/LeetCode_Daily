/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Edge case
        if (head == null)
            return head;

        // Dummy Node
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;

        // Iterate over list and change links
        while (curr.next != null && curr.next.next != null) {
            ListNode s1 = curr.next;
            ListNode s2 = curr.next.next;

            curr.next = s2;
            s1.next = s2.next;
            s2.next = s1;

            curr = s1;
        }

        // Return dummy next
        return dummy.next;
    }
}