package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.Stack;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 */
public class BSTFromPreorder {

    /**
     * Time O(N)
     * Space O(N)
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.add(root);
        int i = 1;
        while (i < preorder.length) {
            TreeNode newNode = new TreeNode(preorder[i]);
            if (preorder[i] < stack.peek().val) {
                stack.peek().left = newNode;
                stack.add(newNode);
            } else {
                TreeNode last = stack.pop();
                while (!stack.isEmpty() && stack.peek().val < preorder[i]) {
                    last = stack.pop();
                }
                last.right = newNode;
                stack.add(newNode);
            }
            i++;
        }
        return root;
    }
}
