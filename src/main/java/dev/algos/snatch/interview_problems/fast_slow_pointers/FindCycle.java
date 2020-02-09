package dev.algos.snatch.interview_problems.fast_slow_pointers;

import dev.algos.snatch.data_structures.linked_list.ListNode;


/**
 * Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 */
public class FindCycle {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public ListNode findCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                var slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public ListNode findCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        var fast = head;
        var slow = head;
        var cycleLen = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                cycleLen = calcCycleLen(slow);
                break;
            }
        }
        return findCycle(cycleLen, head);
    }

    private ListNode findCycle(int len, ListNode head) {
        if (len > 0) {
            var node = head;
            while (len >= 0) {
                node = node.next;
                len--;
            }
            while (head != node) {
                head = head.next;
                node = node.next;
            }
            return head;
        }
        return null;
    }

    private int calcCycleLen(ListNode head) {
        int len = 0;
        var node = head.next;
        while (node != head) {
            len++;
            node = node.next;
        }
        return len;
    }
}
