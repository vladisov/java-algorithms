package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a node, find the level order successor of the given node in the tree.
 * The level order successor is the node that appears right after the given node in the level order traversal.
 */
public class LevelOrderSuccessorOfBinaryTreeNode {

    public Integer findSuccessor(TreeNode root, int key) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode prev = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (prev != null) {
                    if (prev.val == key) {
                        return node.val;
                    }
                }
                prev = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return null;
    }
}
