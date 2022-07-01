/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
         
        // get the number of nodes of the linked list
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
         
        if (len == 1 || n % len == 0) {
            return head;
        }
         
        int steps = len - n % len - 1;
         
        ListNode newHead = head;
        p = head;
        for (int i = 0; i < steps; i++) {
            p = p.next;
        }
         
        newHead = p.next;
        ListNode q = newHead;
        p.next = null;
         
        while(q.next != null) {
            q = q.next;
        }
        q.next = head;
         
        return newHead;
    }
}