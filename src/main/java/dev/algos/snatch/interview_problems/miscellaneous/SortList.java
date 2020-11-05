package dev.algos.snatch.interview_problems.miscellaneous;

import dev.algos.snatch.interview_problems.helpers.ListNode;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class SortList {

    /**
     * Top down appraoch
     * Time O(nlogn)
     * Space O(logn)
     */
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return mergeSort(head);
    }

    ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(slow);
        return merge(l1, l2);
    }

    ListNode merge(ListNode head, ListNode mid) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (head != null && mid != null) {
            if (head.val < mid.val) {
                curr.next = head;
                head = head.next;
            } else {
                curr.next = mid;
                mid = mid.next;
            }
            curr = curr.next;
        }
        while (head != null) {
            curr.next = head;
            head = head.next;
            curr = curr.next;
        }
        while (mid != null) {
            curr.next = mid;
            mid = mid.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
