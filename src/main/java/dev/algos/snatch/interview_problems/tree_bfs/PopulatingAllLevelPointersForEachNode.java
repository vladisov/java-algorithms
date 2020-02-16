package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNodeNext;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 */
public class PopulatingAllLevelPointersForEachNode {

    /**
     * BFS approach
     * Time O(n)
     * Space O(n)
     */
    //TODO optimize to constant space
    public TreeNodeNext connect(TreeNodeNext root) {
        if (root == null) return root;
        Queue<TreeNodeNext> queue = new LinkedList<>();
        queue.add(root);
        TreeNodeNext prev = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeNext node = queue.poll();
                if (prev != null) {
                    prev.next = node;
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
        return root;
    }
}
