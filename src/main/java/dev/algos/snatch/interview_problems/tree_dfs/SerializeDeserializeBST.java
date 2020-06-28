package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeDeserializeBST {

    /**
     * Time O(N)
     * Space O(N)
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] strs = data.split(",");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, strs);
        return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(Queue<String> queue, int low, int high) {
        if (queue.isEmpty()) {
            return null;
        }
        int val = Integer.parseInt(queue.peek());
        if (val < low || val > high) return null;
        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = deserialize(queue, low, val);
        node.right = deserialize(queue, val, high);
        return node;
    }

}
