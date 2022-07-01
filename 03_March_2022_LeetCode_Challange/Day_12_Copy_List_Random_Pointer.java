//package main.cp.leetcode._2021._02_february;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 11/2/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=Jo4Oko5Y6T
 */

    // O(N) time and O(N) Extra Space

    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap();

            Node dummyHead = new Node(-1);
            Node current = head, copy = dummyHead;

            while (current != null) {
                copy.next = new Node(current.val);
                copy = copy.next;
                map.put(current, copy);
                current = current.next;
            }

            current = head;
            copy = dummyHead.next;

            while (current != null) {
                copy.random = map.get(current.random);
                copy = copy.next;
                current = current.next;
            }

            return dummyHead.next;
        }
    }

