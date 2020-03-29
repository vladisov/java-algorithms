package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * <p>
 * Return:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class AllPathForSum {

    /**
     * Time complexity O(h) - > O(n)
     * Space complexity O(h) -> O(n)
     */
    public List<List<Integer>> pathSumRec(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> values = new Stack<>();
        values.add(root.val);
        pathSumHelper(root.left, sum - root.val, values, result);
        pathSumHelper(root.right, sum - root.val, values, result);
        return result;
    }

    private void pathSumHelper(TreeNode root, int sum, Stack<Integer> values, List<List<Integer>> result) {
        if (root == null) return;

        values.add(root.val);
        sum -= root.val;

        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(values));
        } else {
            pathSumHelper(root.left, sum, values, result);
            pathSumHelper(root.right, sum, values, result);
        }
        values.pop();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> values = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                sum -= root.val;
                values.add(root.val);
                stack.add(root);
                root = root.left;
            }

            if (sum == 0 && stack.peek().left == null && stack.peek().right == null) {
                result.add(new ArrayList<>(values));
            }

            while (!stack.isEmpty() && stack.peek().right == root) {
                root = stack.pop();
                values.pop();
                sum += root.val;
            }

            root = stack.isEmpty() ? null : stack.peek().right;
        }

        return result;
    }
}
