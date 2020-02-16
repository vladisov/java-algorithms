package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return an array containing all the boundary nodes of the tree in an anti-clockwise direction.
 * <p>
 * The boundary of a tree contains all nodes in the left view, all leaves, and all nodes in the right view.
 * Please note that there should not be any duplicate nodes.
 * For example, the root is only included in the left view; similarly,
 * if a level has only one node we should include it in the left view.
 */
public class TreeBoundary {

    /**
     * Time O(n)
     * Space O(n)
     */
    public List<Integer> findBoundary(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> leftView = new ArrayList<>();
        List<Integer> rightView = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0 && !isLeaf(node)) {
                    leftView.add(node.val);
                } else if (i == size - 1 && !isLeaf(node)) {
                    rightView.add(node.val);
                } else if (isLeaf(node)) {
                    leaves.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        result.addAll(leftView);
        result.addAll(leaves);
        result.addAll(rightView);
        return result;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public List<Integer> findBoundary1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> levels = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levels.add(level);
        }
        int i;
        for (i = 0; i < levels.size() - 1; i++) {
            result.add(levels.get(i).get(0));
        }
        result.addAll(levels.get(i--));
        for (; i > 0; i--) {
            result.add(levels.get(i).get(levels.get(i).size() - 1));
        }
        return result;
    }
}
