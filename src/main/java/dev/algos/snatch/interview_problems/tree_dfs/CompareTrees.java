package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.ds_design.BSTIterator;
import dev.algos.snatch.interview_problems.helpers.TreeNode;

public class CompareTrees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(5);
        TreeNode l11 = new TreeNode(1);
        TreeNode r11 = new TreeNode(3);
        TreeNode r12 = new TreeNode(6);

        root1.left = l1;
        root1.right = r1;
        r1.right = r12;
        l1.left = l11;
        l1.right = r11;

        TreeNode root2 = new TreeNode(4);
        TreeNode l2 = new TreeNode(3);
        TreeNode r2 = new TreeNode(5);
        TreeNode l22 = new TreeNode(2);
        TreeNode r22 = new TreeNode(6);
        TreeNode l23 = new TreeNode(1);
        TreeNode l24 = new TreeNode(-5);

        root2.left = l2;
        root2.right = r2;
        l2.left = l22;
        r2.right = r22;
        l22.left = l23;
        l23.left = l24;

        CompareTrees scratch = new CompareTrees();
        System.out.println(scratch.sameTrees(root1, root2));
    }

    /**
     * N - first, M - second
     * Time O(leftDiff + M) where leftDiff = min value from N till M start
     */
    public boolean sameTrees(TreeNode root1, TreeNode root2) {
        BSTIterator it1 = new BSTIterator(root1);
        BSTIterator it2 = new BSTIterator(root2);

        if (it1.hasNext() && it2.hasNext()) {
            int val1 = it1.next();
            int val2 = it2.next();
            while (it1.hasNext() && val1 < val2) {
                val1 = it1.next();
            }
            while (it2.hasNext() && val2 < val1) {
                val2 = it2.next();
            }

            if (val1 != val2) return false;

            while (it1.hasNext() && it2.hasNext()) {
                val1 = it1.next();
                val2 = it2.next();
                if (val1 != val2) return false;
            }
        }
        return true;
    }
}
