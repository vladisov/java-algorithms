package dev.algos.snatch.interview_problems.helpers;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode parseFromPreOrder(String str) {
        String[] values = str.substring(1, str.length() - 1).split(",");
        Queue<String> queue = new LinkedList<>(List.of(values));
        return deserializePreOrder(queue);
    }

    //[3,9,20,null,null,15,7]
    public static TreeNode parseFromLevelOrder(String str) {
        if (str == null || str.length() <= 2) {
            return null;
        }
        String[] values = str.substring(1, str.length() - 1)
                .split(",");
        Queue<String> queue = new LinkedList<>(List.of(values));
        return deserializeLevelOrder(queue);
    }

    private static TreeNode deserializeLevelOrder(Queue<String> queue) {
        String nodeStr = queue.poll();
        Queue<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeStr));
        list.add(root);
        while (!queue.isEmpty()) {
            int lvlSize = list.size(), i = 0;
            while (i < lvlSize) {
                TreeNode node = list.poll();
                TreeNode left = getNode(queue.poll());
                TreeNode right = getNode(queue.poll());
                if (left != null) {
                    node.left = left;
                    list.add(left);
                }
                if (right != null) {
                    node.right = right;
                    list.add(right);
                }
                i++;
            }
        }
        return root;
    }

    private static TreeNode getNode(String str) {
        if (str == null || str.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(str));
    }

    private static TreeNode deserializePreOrder(Queue<String> queue) {
        String nodeStr = queue.poll();
        if (nodeStr == null || nodeStr.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeStr));
        node.left = deserializePreOrder(queue);
        node.right = deserializePreOrder(queue);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        printInorder(this, sb);
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String toStringPreOrder() {
        StringBuilder sb = new StringBuilder();
        printPreOrder(this, sb);
        return sb.toString();
    }

    public String toStringLevelOrder() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        List<List<Integer>> levels = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    level.add(null);
                } else {
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!level.stream().allMatch(Objects::isNull)) {
                levels.add(level);
            }
        }
        for (List<Integer> list : levels) {
            for (var val : list) {
                sb.append(val).append(",");
            }
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1)
                    .insert(0, "[")
                    .append("]");
        }
        return sb.toString();
    }

    private void printPreOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null");
            return;
        }
        sb.append(node.val).append(",");
        if (node.left != null)
            printInorder(node.left, sb);
        if (node.right != null)
            printInorder(node.right, sb);
    }

    private void printInorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
            return;
        }
        if (node.left != null)
            printInorder(node.left, sb);
        sb.append(node.val).append(",");
        if (node.right != null)
            printInorder(node.right, sb);
    }
}
