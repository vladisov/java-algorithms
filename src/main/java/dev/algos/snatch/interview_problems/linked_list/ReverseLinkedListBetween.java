package dev.algos.snatch.interview_problems.linked_list;

import dev.algos.snatch.data_structures.linked_list.ListNode;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * <p>
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/reverse-linked-list-ii/">92. Reverse Linked List II</a>
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
        if (preStart != null) {
            preStart.next = prev;
        } else {
            head = prev;
        }

        return head;
    }
}
