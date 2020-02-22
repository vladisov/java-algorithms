package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

/**
 * Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.
 * A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.
 */
public class PathToMaxSum {

    int max = Integer.MIN_VALUE;

    /**
     * Time complexity O(n)
     * Space complexity O(n)
     */
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode root) {
        if (root == null)
            return 0;

        int maxPathSumFromLeft = maxPath(root.left);
        int maxPathSumFromRight = maxPath(root.right);

        // ignore paths with negative sums, since we need to find the maximum sum we should
        // ignore any path which has an overall negative sum.
        maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
        maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

        // maximum path sum at the current node will be equal to the sum from the left subtree +
        // the sum from right subtree + val of current node
        int localMaximumSum = maxPathSumFromLeft + maxPathSumFromRight + root.val;

        // update the global maximum sum
        max = Math.max(max, localMaximumSum);

        // maximum sum of any path from the current node will be equal to the maximum of
        // the sums from left or right subtrees plus the value of the current node
        return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + root.val;
    }
}
