package dev.algos.snatch.interview_problems.ds_design;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 */
public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addLeftSubTree(root);
    }

    private void addLeftSubTree(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        var next = stack.pop();
        addLeftSubTree(next.right);
        return next.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
