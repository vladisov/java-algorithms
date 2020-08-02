package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 */
public class RecoverBinarySearchTree {

    /**
     * O(N) time
     * O(N) space O(H) actually
     */
    private TreeNode prev, x, y;

    void recoverTree(TreeNode root) {
        helper(root);
        swap();
    }

    private void swap() {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null && prev.val > root.val) {
            y = root;
            if (x == null) {
                x = prev;
            }
        }

        prev = root;
        helper(root.right);
    }

    public void recoverTreeIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null, leftSwap = null, rightSwap = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val > root.val) {
                rightSwap = root;
                if (leftSwap == null) {
                    leftSwap = prev;
                }
            }
            prev = root;
            root = root.right;
        }
        swap(leftSwap, rightSwap);
    }

    private void swap(TreeNode root, TreeNode prev) {
        int tmp = root.val;
        root.val = prev.val;
        prev.val = tmp;
    }
}
