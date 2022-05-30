package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElements {

    TreeNode root;
    Set<Integer> values;

    public FindElements(TreeNode root) {
        this.values = new HashSet<>();
        this.recover(root, 0);
        this.root = root;
    }

    /**
     * Time O(1)
     */
    public boolean find(int target) {
        return values.contains(target);
    }

    /**
     * Time O(N)
     * Space O(N) rec
     */
    void recover(TreeNode node, int val) {
        if (node == null) return;
        node.val = val;
        values.add(val);
        recover(node.left, 2 * val + 1);
        recover(node.right, 2 * val + 2);
    }
}
