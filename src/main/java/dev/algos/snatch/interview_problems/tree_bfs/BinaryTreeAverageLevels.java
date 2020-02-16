package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
public class BinaryTreeAverageLevels {

    /**
     * Time complexity O(n) n - number of nodes
     * Space complexity O(n) n - nodes on any level (n/2 at most on last lvl)
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> averages = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0d;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            averages.add(sum / size);
        }
        return averages;
    }
}
