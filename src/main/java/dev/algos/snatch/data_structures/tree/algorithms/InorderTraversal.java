package dev.algos.snatch.data_structures.tree.algorithms;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

    public List<Integer> inorderTraversalMorris(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root, prev = null;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr;
                var tmp = curr;
                curr = curr.left;
                tmp.left = null;
            }
        }
        return result;
    }
}
