package dev.algos.snatch.interview_problems.tree_dfs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 * <p>
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation:
 */
public class FlattenMultilevelLinkedList {

    /**
     * Time O(N)
     * Space O(N)
     */
    public Node flatten(Node head) {
        if (head == null) return head;
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        Node prev = null;
        stack.add(head);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            visited.add(node);
            if (prev != null) {
                prev.next = node;
                node.prev = prev;
            }
            if (node.next != null && !visited.contains(node.next)) {
                stack.add(node.next);
            }
            if (node.child != null && !visited.contains(node.child)) {
                stack.add(node.child);
            }
            node.child = null;
            prev = node;
        }
        return head;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

}
