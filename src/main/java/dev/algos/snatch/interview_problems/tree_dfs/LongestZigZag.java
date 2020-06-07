package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

/**
 * Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
 * <p>
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right then move to the right child of the current node otherwise move to the left child.
 * Change the direction from right to left or right to left.
 * Repeat the second and third step until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 * <p>
 * Return the longest ZigZag path contained in that tree.
 * <p>
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 */
public class LongestZigZag {

    /**
     * Time O(N)
     * Space O(H)
     */
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        return Math.max(longestZigZag(root.left, true, 0), longestZigZag(root.right, false, 0));
    }

    private int longestZigZag(TreeNode root, boolean fromLeft, int depth) {
        if (root == null) return depth;
        depth++;
        int d1, d2;
        if (fromLeft) {
            d1 = longestZigZag(root.right, false, depth);
            d2 = longestZigZag(root.left, true, 0);
        } else {
            d1 = longestZigZag(root.left, true, depth);
            d2 = longestZigZag(root.right, false, 0);
        }
        return Math.max(d1, d2);
    }
}
