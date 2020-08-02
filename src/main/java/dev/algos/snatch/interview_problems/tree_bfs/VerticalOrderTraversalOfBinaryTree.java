package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * <p>
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 * <p>
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 * <p>
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 * <p>
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Without loss of generality, we can assume the root node is at position (0, 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * The node with value 5 and the node with value 6 have the same position according to the given scheme.
 * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 */
public class VerticalOrderTraversalOfBinaryTree {

    /**
     * Time O(N)
     * Space O(N)
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return List.of();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] sides = traverse(root, map);
        int min = sides[0];
        int max = sides[1];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    private int[] traverse(TreeNode root, Map<Integer, List<Integer>> map) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(root, 0));
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.poll();

                map.putIfAbsent(node.side, new ArrayList<>());
                map.get(node.side).add(node.node.val);

                max = Math.max(max, node.side);
                min = Math.min(min, node.side);

                if (node.node.left != null) {
                    queue.add(new Node(node.node.left, node.side - 1));
                }
                if (node.node.right != null) {
                    queue.add(new Node(node.node.right, node.side + 1));
                }
            }
        }
        return new int[]{min, max};
    }

    static class Node {
        TreeNode node;
        int side;

        public Node(TreeNode node, int i) {
            this.node = node;
            this.side = i;
        }
    }
}
