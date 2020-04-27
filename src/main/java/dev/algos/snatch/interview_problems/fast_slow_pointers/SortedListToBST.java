package dev.algos.snatch.interview_problems.fast_slow_pointers;

import dev.algos.snatch.data_structures.linked_list.ListNode;
import dev.algos.snatch.interview_problems.helpers.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted linked list: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class SortedListToBST {

    /**
     * Time O(NlogN)
     * Space O(logN)
     */
    public TreeNode sortedListToBST(ListNode<Integer> head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode<Integer> head, ListNode<Integer> tail) {
        if (tail != null && head.value > tail.value) return null;

        if (head == tail) return new TreeNode(head.value);

        ListNode slow = head, fast = head, prev = null;
        while (fast != tail && fast.next != tail) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode((int) slow.value);
        if (prev != null) {
            node.left = helper(head, prev);
        }
        if (slow.next != null) {
            node.right = helper(slow.next, tail);
        }
        return node;
    }

    /**
     * Time O(N)
     * Space O(logN) recursion call
     */
    static class Solution {
        ListNode<Integer> node;

        public TreeNode sortedListToBST(ListNode<Integer> head) {
            if (head == null) return null;
            int size = 0;
            var runner = head;
            node = head;
            while (runner != null) {
                runner = runner.next;
                size++;
            }
            return solveInorder(0, size - 1);
        }

        private TreeNode solveInorder(int start, int end) {
            if (start > end) return null;
            int mid = start + (end - start) / 2;
            TreeNode left = solveInorder(start, mid - 1);
            TreeNode treeNode = new TreeNode(node.value);
            treeNode.left = left;
            node = node.next;
            treeNode.right = solveInorder(mid + 1, end);
            return treeNode;
        }
    }
}
