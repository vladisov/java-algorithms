package dev.algos.snatch.interview_problems.reversal_linked_list;

import dev.algos.snatch.data_structures.linked_list.ListNode;

/**
 * Reverse Linked List
 */
public class ReverseLinkedList {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, curr = head;
        while (curr != null) {
            var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
