package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * <p>
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 */
public class AllNodesDistanceKInBinaryTree {

    /**
     * Time complexity O(n)
     * Space complexity O(n)
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return List.of();
        List<Integer> result = new ArrayList<>();
        if (root.equals(target)) {
            findPathToLeaf(root, k, result);
            return result;
        }
        List<TreeNode> path = buildPath(root, target, new ArrayList<>());
        findPathToLeaf(target, k, result);
        TreeNode prev = target;
        for (int i = path.size() - 1; i >= 0; i--) {
            TreeNode curr = path.get(i);
            if (k - 1 == 0) {
                result.add(curr.val);
                break;
            }
            if (curr.left != null && !curr.left.equals(prev)) {
                findPathToLeaf(curr.left, k - 2, result);
            }
            if (curr.right != null && !curr.right.equals(prev)) {
                findPathToLeaf(curr.right, k - 2, result);
            }
            k--;
            prev = curr;
        }
        return result;
    }

    void findPathToLeaf(TreeNode root, int k, List<Integer> result) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            result.add(root.val);
            return;
        }
        findPathToLeaf(root.left, k - 1, result);
        findPathToLeaf(root.right, k - 1, result);
    }


    List<TreeNode> buildPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return null;
        }
        if (root.equals(target)) {
            return path;
        }
        path.add(root);
        List<TreeNode> left = buildPath(root.left, target, path);
        if (left != null) {
            return left;
        }
        List<TreeNode> right = buildPath(root.right, target, path);
        if (right != null) {
            return right;
        }
        path.remove(path.size() - 1);
        return null;
    }
}
