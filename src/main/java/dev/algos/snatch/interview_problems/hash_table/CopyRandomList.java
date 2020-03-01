package dev.algos.snatch.interview_problems.hash_table;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    //TODO test + another approach (1 - 1' - 2 - 2' etc.)
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        var curr = head;
        Node newCurr = null;
        Node prev = dummy;
        dummy.next = newCurr;
        while (curr != null) {
            newCurr = new Node(curr.val);
            newCurr.random = curr.random;
            map.put(curr, newCurr);
            prev.next = newCurr;
            prev = newCurr;

            curr = curr.next;
            newCurr = newCurr.next;
        }

        curr = dummy.next;
        while (curr != null) {
            curr.random = map.get(curr.random);
            curr = curr.next;
        }

        return dummy.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
