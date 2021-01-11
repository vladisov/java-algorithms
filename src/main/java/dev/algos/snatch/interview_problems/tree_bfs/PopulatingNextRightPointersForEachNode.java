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
public class PopulatingNextRightPointersForEachNode {

    /**
     * BFS approach
     * Time O(n)
     * Space O(n)
     */
    public TreeNodeNext connect(TreeNodeNext root) {
        if (root == null) return null;
        Queue<TreeNodeNext> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNodeNext prev = null;
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

    /**
     * Kotlin version with constant space
     * TC O(N)
     * SC O(1)
     */
    /*
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(_root: Node?): Node? {
        var root = _root
        val tmp = Node(0)
        while (root != null) {
            var child = tmp
            while (root != null) {
                if (root.left != null) {
                    child.next = root.left
                    child = child.next!!
                }
                if (root.right != null) {
                    child.next = root.right
                    child = child.next!!
                }
                root = root.next
            }
            root = tmp.next
            tmp.next = null
        }
        return _root
    }
     */
}
