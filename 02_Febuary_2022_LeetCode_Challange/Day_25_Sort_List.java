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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode preSlow =null, slow=head, fast = head;
        while(fast !=null && fast.next !=null){
            preSlow =slow;
            slow =slow.next;
            fast =fast.next.next;
        }
        
        preSlow.next =null;
        return  mergeTwoLists (sortList (head), sortList (slow));
        
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy =new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null){
            if(l1.val<l2.val){
                cur.next =l1;
                l1 =l1.next;
            }else{
                cur.next =l2;
                l2=l2.next;
            }
            cur =cur.next;
            
        }
        cur.next =l1 !=null ? l1:l2;
        return dummy.next;
    }
}