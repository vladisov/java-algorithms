package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

/**
 * Given a binary tree where each path going from the root to any
 * leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
 * <p>
 * We get the given string from the concatenation of an array of integers arr
 * and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 */
public class IsValidSequenceFromRootToLeaf {

    /**
     * Time O(N)
     * Space O(H) recursion stack
     */
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (arr.length == 0 || root == null) return false;
        return isValid(root, arr, 0);
    }

    boolean isValid(TreeNode root, int[] arr, int i) {
        if (i >= arr.length || arr[i] != root.val) return false;
        if (isLeaf(root) && i == arr.length - 1) {
            return true;
        }
        boolean left = false, right = false;
        if (root.left != null) {
            left = isValid(root.left, arr, i + 1);
        }
        if (root.right != null) {
            right = isValid(root.right, arr, i + 1);
        }
        return left || right;
    }

    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
