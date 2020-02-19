package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

/**
 * Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
 */
public class PathWithGivenSequence {

    public boolean findPath(TreeNode root, int[] sequence) {
        if (root == null) return sequence.length == 0;

        return findPath(root, sequence, 0);
    }

    private boolean findPath(TreeNode root, int[] sequence, int i) {
        if (root == null || i >= sequence.length || root.val != sequence[i]) return false;

        if (i == sequence.length - 1 && isLeaf(root)) {
            return true;
        }

        return findPath(root.left, sequence, i + 1) || findPath(root.right, sequence, i + 1);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
