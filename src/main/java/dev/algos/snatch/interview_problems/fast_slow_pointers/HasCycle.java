package dev.algos.snatch.interview_problems.fast_slow_pointers;

import dev.algos.snatch.data_structures.linked_list.ListNode;

/**
 * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 */
public class HasCycle {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
