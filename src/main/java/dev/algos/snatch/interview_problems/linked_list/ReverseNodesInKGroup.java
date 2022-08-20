package dev.algos.snatch.interview_problems.linked_list;

import dev.algos.snatch.data_structures.linked_list.ListNode;

public class ReverseNodesInKGroup {

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
        while (curr != null && i + k <= size) {
            ListNode reversed = reverse(curr, head, k);
            curr = reversed; // 1
            if (curr == null) {
                break;
            }
            head = reversed.next; // 3
            i += k;
        }
        return dummy.next;
    }

    int getSize(ListNode head) {
        int size = 0;
        if (head == null) return size;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    ListNode reverse(ListNode prev, ListNode head, int k) {
        if (head == null) return head; // d 1 2 3
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
