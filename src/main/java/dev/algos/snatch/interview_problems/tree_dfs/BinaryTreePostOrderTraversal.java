package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostOrderTraversal {

    /**
     * Time O(N) number of nodes
     * Space O(N)
     */
    public List<Integer> postOrderTraversal2(TreeNode root) {
        if (root == null) return List.of();
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.addFirst(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        return result;
    }

    /**
     * Time O(N) number of nodes
     * Space O(N)
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                visited.add(root);
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.right == null || visited.contains(root.right)) {
                result.add(root.val);
                root = null;
            } else {
                stack.add(root);
                root = root.right;
            }
        }
        return result;
    }
}
