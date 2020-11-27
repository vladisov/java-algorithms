package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PrintTree {

    public static void main(String[] args) {
        PrintTree scratch = new PrintTree();
        System.out.println(scratch.printTree(TreeNode.parseFromLevelOrder("[1,2,3,null,4,null,null,null,5,null,6]")).toString());
    }

    /**
     * Time O(N)
     * Space O(2^height * 2)
     */
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) return List.of();
        int height = getHeight(root) - 1;
        int width = ((1 << height) - 1) * 2 + 1;
        String[][] tree = new String[height + 1][width];
        fillTree(tree, root);
        List<List<String>> result = new ArrayList<>();
        for (String[] row : tree) {
            List<String> rowList = new ArrayList<>();
            for (String s : row) {
                if (s == null) s = "";
                rowList.add(s);
            }
            result.add(rowList);
        }
        return result;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private void fillTree(String[][] tree, TreeNode root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, tree[0].length - 1, root));
        int lvl = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                int lo = node.lo;
                int hi = node.hi;
                int mid = lo + (hi - lo) / 2;
                tree[lvl][mid] = String.valueOf(node.node.val);
                if (node.node.left != null) {
                    queue.add(new Node(lo, mid - 1, node.node.left));
                }
                if (node.node.right != null) {
                    queue.add(new Node(mid + 1, hi, node.node.right));
                }
            }
            lvl++;
        }
    }

    static class Node {
        int lo;
        int hi;
        TreeNode node;

        public Node(int lo, int hi, TreeNode node) {
            this.lo = lo;
            this.hi = hi;
            this.node = node;
        }
    }
}
