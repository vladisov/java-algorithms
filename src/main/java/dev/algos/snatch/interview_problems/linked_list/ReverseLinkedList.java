package dev.algos.snatch.interview_problems.linked_list;

import dev.algos.snatch.data_structures.linked_list.ListNode;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/reverse-linked-list/">206. Reverse Linked List</a>
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

    public ListNode reverseRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
