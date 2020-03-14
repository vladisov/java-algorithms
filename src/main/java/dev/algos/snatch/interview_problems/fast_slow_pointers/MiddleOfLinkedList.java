package dev.algos.snatch.interview_problems.fast_slow_pointers;

import dev.algos.snatch.data_structures.linked_list.ListNode;

/**
 * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
 * <p>
 * If the total number of nodes in the LinkedList is even, return the second middle node.
 * <p>
 * Example 1:
 * <p>
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
 * Output: 3
 * Example 2:
 * <p>
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
 * Output: 4
 * Example 3:
 * <p>
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
 * Output: 4
 *
 * LeetCode: <a href="https://leetcode.com/problems/middle-of-the-linked-list/">876. Middle of the Linked List</a>
 */
public class MiddleOfLinkedList {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) return head;
        var fast = head;
        var slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
