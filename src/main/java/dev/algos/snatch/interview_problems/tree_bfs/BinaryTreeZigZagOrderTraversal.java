package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * /  \
 * 9   20
 * /  \
 * 15  7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigZagOrderTraversal {

    /**
     * Time complexity O(n) n - number of nodes
     * Space complexity O(n) n - nodes on any level (n/2 at most on last lvl)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int lvl = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (lvl % 2 == 0) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            lvl++;
            result.add(level);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrderStacks(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(root);
        List<Integer> tmp;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            tmp = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                tmp.add(node.val);
                if (node.left != null) {
                    s2.add(node.left);
                }
                if (node.right != null) {
                    s2.add(node.right);
                }
            }
            result.add(new ArrayList<>(tmp));
            tmp = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                tmp.add(node.val);
                if (node.right != null) {
                    s1.add(node.right);
                }
                if (node.left != null) {
                    s1.add(node.left);
                }
            }
            if (!tmp.isEmpty()) {
                result.add(new ArrayList<>(tmp));
            }
        }
        return result;
    }
}
