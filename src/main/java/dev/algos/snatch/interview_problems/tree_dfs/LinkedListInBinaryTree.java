package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.ListNode;
import dev.algos.snatch.interview_problems.helpers.TreeNode;

/**
 * Given a binary tree root and a linked list with head as the first node.
 * <p>
 * Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
 * <p>
 * In this context downward path means a path that starts at some node and goes downwards.
 * <p>
 * https://leetcode.com/problems/linked-list-in-binary-tree/
 */
public class LinkedListInBinaryTree {

    /**
     * Time O(N min(L,H))
     * Space O(H)
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return helper(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean helper(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return head.val == root.val && (helper(head.next, root.left) || helper(head.next, root.right));
    }
}
