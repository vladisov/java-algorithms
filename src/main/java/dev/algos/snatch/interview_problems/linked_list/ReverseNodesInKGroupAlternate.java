package dev.algos.snatch.interview_problems.linked_list;

import dev.algos.snatch.data_structures.linked_list.ListNode;

/**
 * Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.
 * <p>
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 * <p>
 * Educative: <a href="https://www.educative.io/courses/grokking-the-coding-interview/m2YYJJRP9KG">Reverse alternating K-element Sub-list (medium)</a>
 */
public class ReverseNodesInKGroupAlternate {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = getSize(head);
        if (k > size || size <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        var curr = dummy;
        int i = 0;
        while (curr != null && i <= size) {
            ListNode reversed = reverse(curr, head, k);
            ListNode skipped = skip(reversed.next, k);
            curr = skipped; // 1
            if (curr == null) {
                break;
            }
            head = skipped.next; // 3
            i += 2 * k;
        }
        return dummy.next;
    }

    int getSize(ListNode head) {
        int size = 0;
        if (head == null) {
            return size;
        }
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    ListNode skip(ListNode head, int k) {
        while (head != null && k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }

    ListNode reverse(ListNode prev, ListNode head, int k) {
        if (head == null) {
            return head; // d 1 2 3
        }
        ListNode oldPrev = prev; // d
        var curr = head; // 1
        ListNode next = null;
        while (curr != null && k > 0) {
            next = curr.next; // 3
            curr.next = prev; // 2 1 d
            prev = curr; // 1 2
            curr = next; // 3
            k--;
        }
        if (oldPrev != null) { // d
            oldPrev.next = prev; // d 2 1 d
        }
        head.next = curr; // d 2 1 3
        return head;
    }
}
