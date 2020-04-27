package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

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
     * Time O(NlogD) where D duplicates D might be N/? -> N
     * Space O(N)
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = traverse(root);
        List<List<Integer>> result = new ArrayList<>(map.size());

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (var key : map.keySet()) {
            min = Math.min(min, key);
            max = Math.max(max, key);
        }

        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    Map<Integer, List<Integer>> traverse(TreeNode node) {
        if (node == null) return Map.of();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeSide> queue = new LinkedList<>();
        queue.add(new TreeSide(node, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, TreeSet<Integer>> lvlMap = new HashMap<>();
            for (int i = 0; i < size; i++) {
                TreeSide nodeSide = queue.poll();
                lvlMap.putIfAbsent(nodeSide.side, new TreeSet<>());
                lvlMap.get(nodeSide.side).add(nodeSide.node.val);

                if (nodeSide.node.left != null) {
                    queue.add(new TreeSide(nodeSide.node.left, nodeSide.side - 1));
                }
                if (nodeSide.node.right != null) {
                    queue.add(new TreeSide(nodeSide.node.right, nodeSide.side + 1));
                }
            }
            for (Map.Entry<Integer, TreeSet<Integer>> entry : lvlMap.entrySet()) {
                map.putIfAbsent(entry.getKey(), new LinkedList<>());
                map.get(entry.getKey()).addAll(entry.getValue());
            }
        }
        return map;
    }

    static class TreeSide {
        TreeNode node;
        int side;

        public TreeSide(TreeNode node, int side) {
            this.side = side;
            this.node = node;
        }
    }
}
