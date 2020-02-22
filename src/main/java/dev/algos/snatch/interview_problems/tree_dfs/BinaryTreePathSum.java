package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree and a number ‘S’,
 * find if the tree has a path from root-to-leaf such that the sum of all
 * the node values of that path equals ‘S’.
 */
public class BinaryTreePathSum {

    /**
     * Time O(n)
     * Space O(n)
     */
    public boolean hasPath(TreeNode root, int sum) {
        if (root == null)
            return false;

        // if the current node is a leaf and its value is equal to the sum, we've found a path
        if (root.val == sum && root.left == null && root.right == null)
            return true;

        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recursive call return true
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }

    public boolean hasPathIterative(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                sum -= root.val;
                root = root.left;
            }

            if (sum == 0 && stack.peek().left == null && stack.peek().right == null) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek().right == root) {
                root = stack.pop();
                sum += root.val;
            }

            root = stack.isEmpty() ? null : stack.peek().right;
        }

        return false;
    }
}
