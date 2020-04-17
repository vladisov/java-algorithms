package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

public class FlattenBinaryTreeToLL {

    /**
     * Time O(N)
     * Space O(N)
     */
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        if (left != null) {
            left.right = root.right; // set tail right to root
            root.right = root.left; //mix
            root.left = null;
        }
        //find rightmost here
        return right == null ? left : right;
    }

    public void flattenPostOrder(TreeNode root) {
        helper(root, null);
    }

    // helper function takes in the previous head, do the flattening and returns the head of the flatten binary tree
    private TreeNode helper(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }
        prev = helper(root.right, prev);
        prev = helper(root.left, prev);
        root.right = prev;
        root.left = null;
        prev = root;
        return root;
    }

    //todo iterative
}
