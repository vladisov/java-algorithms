package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.Stack;

public class BSTtoDLL {

    public static void main(String[] args) {
        BSTtoDLL scratch = new BSTtoDLL();
        System.out.println(scratch.treeToDoublyList(TreeNode.parseFromLevelOrder("[2,1]")));
    }

    /**
     * Time O(N)
     * Space O(N)
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null, curr = null, head = null, tail = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (prev != null) {
                prev.right = curr;
                curr.left = prev;
            }
            prev = curr;
            curr = stack.pop();
            if (head == null) head = curr;
            root = curr.right;
        }
        if (prev != null) {
            prev.right = curr;
            curr.left = prev;
        }
        tail = curr;
        head.left = tail;
        tail.right = head;
        return head;
    }
}
