package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,4,5]
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 * <p>
 * 4
 * / \
 * 5   2
 * / \
 * 3   1
 */
public class BinaryTreeUpsideDown {

    /**
     * Time O(N)
     * Space O(logn)
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }
}
