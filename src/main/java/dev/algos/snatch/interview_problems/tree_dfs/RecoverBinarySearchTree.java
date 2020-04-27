package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

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
}
