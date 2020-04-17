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

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int depth = calcDepth(root);
        if (depth == 0) return 1;
        int left = 1, right = (int) Math.pow(2, depth) - 1;

        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (exists(pivot, depth, root)) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return (int) Math.pow(2, depth) - 1 + left;
    }

    boolean exists(int idx, int depth, TreeNode node) {
        int left = 0, right = (int) Math.pow(2, depth) - 1;
        for (int i = 0; i < depth; i++) {
            int pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }

        return node != null;
    }

    int calcDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        while (root.left != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}
