package dev.algos.snatch.interview_problems.linked_list;

import dev.algos.snatch.interview_problems.helpers.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 * <p>
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 */
public class OddEvenNodesLinkedList {

    /**
     * Time O(N)
     * Space O(1)
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode dummyOdd = new ListNode(0);
        ListNode dummyEven = new ListNode(0);
        ListNode curr = head, currOdd = dummyOdd, currEven = dummyEven;
        int index = 1;
        while (curr != null) {
            if (index % 2 != 0) {
                currOdd.next = curr;
                currOdd = currOdd.next;
            } else {
                currEven.next = curr;
                currEven = currEven.next;
            }
            curr = curr.next;
            index++;
        }
        currEven.next = null;
        currOdd.next = dummyEven.next;
        return dummyOdd.next;
    }
}
