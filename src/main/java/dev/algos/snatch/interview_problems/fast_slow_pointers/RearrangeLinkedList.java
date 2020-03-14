package dev.algos.snatch.interview_problems.fast_slow_pointers;

import dev.algos.snatch.data_structures.linked_list.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * LeetCode: <a href="https://leetcode.com/problems/reorder-list/">143. Reorder List</a>
 */
public class RearrangeLinkedList<T> {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public void reorder(ListNode<T> head) {
        if (head == null || head.next == null) return;
        var mid = findMid(head);
        var reversed = reverse(mid);
        var curr = head;
        while (curr != null && reversed.next != null) {
            var next = curr.next;
            var reversedNext = reversed.next;

            curr.next = reversed;
            if (next != null)
                reversed.next = next;

            curr = next;
            reversed = reversedNext;
        }
    }

    private ListNode<T> findMid(ListNode<T> head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode<T> reverse(ListNode<T> head) {
        ListNode<T> prev = null;
        while (head != null) {
            var next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
