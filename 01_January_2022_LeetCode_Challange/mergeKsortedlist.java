/* #Problem 23
We are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []

*/


public ListNode mergeKLists(ListNode[] lists) {
    if(lists==null||lists.length==0)
        return null;
 
    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
        public int compare(ListNode l1, ListNode l2){
            return l1.val - l2.val;
        }
    });
 
    ListNode head = new ListNode(0);
    ListNode p = head;
 
    for(ListNode list: lists){
        if(list!=null)
            queue.offer(list);
    }    
 
    while(!queue.isEmpty()){
        ListNode n = queue.poll();
        p.next = n;
        p=p.next;
 
        if(n.next!=null)
            queue.offer(n.next);
    }    
 
    return head.next;
 
}
