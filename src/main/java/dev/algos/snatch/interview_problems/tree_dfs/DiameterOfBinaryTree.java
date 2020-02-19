package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

/**
 * Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
 */
public class DiameterOfBinaryTree {

    int diameter;

    /**
     * Time complexity O(n)
     * Space complexity O(h) -> O(n)
     */
    public int findDiameter(TreeNode root) {
        calcHeight(root);
        return diameter;
    }

    private int calcHeight(TreeNode root) {
        if (root == null) return 0;

        int left = calcHeight(root.left);
        int right = calcHeight(root.right);

        diameter = Math.max(diameter, left + right + 1);

        return Math.max(left, right) + 1;
    }
}
