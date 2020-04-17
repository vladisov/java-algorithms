package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DeleteNodeAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> nodes = new ArrayList<>();
        addNodes(root, nodes);
        Set<Integer> deleted = new HashSet<>();
        for (int del : to_delete) {
            deleted.add(del);
        }

        Set<Integer> visited = new HashSet<>();
        List<TreeNode> result = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (!deleted.contains(node.val) && !visited.contains(node.val)) {
                result.add(buildSubtree(node, visited, deleted));
            }
        }
        return result;
    }

    private TreeNode buildSubtree(TreeNode node, Set<Integer> visited, Set<Integer> deleted) {
        visited.add(node.val);
        if (node.left != null) {
            if (deleted.contains(node.left.val)) {
                node.left = null;
            } else {
                buildSubtree(node.left, visited, deleted);
            }
        }
        if (node.right != null) {
            if (deleted.contains(node.right.val)) {
                node.right = null;
            } else {
                buildSubtree(node.right, visited, deleted);
            }
        }
        return node;
    }

    private void addNodes(TreeNode root, List<TreeNode> nodes) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                nodes.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
}
