package dev.algos.snatch.interview_problems.reversal_linked_list;

import dev.algos.snatch.data_structures.linked_list.ListNode;

/**
 * Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListBetween {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public ListNode reverse(ListNode head, int n, int m) {
        if (head == null || head.next == null) return head;
        ListNode curr = head, prev = null;
        for (int i = m; i > 1; i--) {
            prev = curr;
            curr = curr.next;
        }
        var preStart = prev;
        var start = curr;
        ListNode next;
        int k = n - m;
        while (curr != null && k >= 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        start.next = curr;
        if (preStart != null)
            preStart.next = prev;
        else
            head = prev;

        return head;
    }
}
