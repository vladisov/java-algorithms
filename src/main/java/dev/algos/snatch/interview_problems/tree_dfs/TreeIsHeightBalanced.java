package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

public class TreeIsHeightBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left, 0);
        int right = depth(root.right, 0);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int depth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(depth(root.left, depth + 1), depth(root.right, depth + 1));
    }
}
