package dev.algos.snatch.interview_problems.binary_search;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * Output: 6
 */
public class CountCompleteTreeNodes {

    /**
     * Time O(logN^2)
     * logN (first level) + logN-1 (second level) + logN-2 (third level) .... + 1 (last level) = logN(logN+1)/2 = O((logN)^2)
     */
    public int countNodes(TreeNode root) {
        int left = depthLeft(root);
        int right = depthRight(root);
        if (left == right) {
            return (1 << left) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int depthLeft(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    int depthRight(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        while (root != null) {
            root = root.right;
            depth++;
        }
        return depth;
    }


}
