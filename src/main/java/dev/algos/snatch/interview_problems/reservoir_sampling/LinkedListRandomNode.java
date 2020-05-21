package dev.algos.snatch.interview_problems.reservoir_sampling;


import java.util.Random;

/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * <p>
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 * <p>
 * Example:
 * <p>
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * <p>
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 */
/*
    Solution

    When we read the first node head, if the stream ListNode stops here, we can just return the head.val. The possibility is 1/1.
    When we read the second node, we can decide if we replace the result r or not. The possibility is 1/2.
    So we just generate a random number between 0 and 1, and check if it is equal to 1. If it is 1, replace r as the value of the current node,
    otherwise we don't touch r, so its value is still the value of head.
    When we read the third node, now the result r is one of value in the head or second node.
    We just decide if we replace the value of r as the value of current node(third node).
    The possibility of replacing it is 1/3, namely the possibility of we don't touch r is 2/3.
    So we just generate a random number between 0 ~ 2, and if the result is 2 we replace r.
    We can continue to do like this until the end of stream ListNode.

    https://leetcode.com/problems/linked-list-random-node/discuss/85662/java-solution-with-cases-explain
 */
public class LinkedListRandomNode {

    private final Random random;
    private final ListNode head;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        this.random = new Random();
        this.head = head;
    }

    /**
     * Returns a random node's value.
     * 0 1 -> 1/2
     * 0 1 2 - 1/3 to choose 2 and 2/3
     * that we keep current result
     */
    public int getRandom() {
        ListNode curr = head;
        int i = 0;
        int res = 0;
        while (curr != null) {
            int randomNum = random.nextInt(i + 1);
            if (randomNum == i) {
                res = curr.val;
            }
            curr = curr.next;
            i++;
        }
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
