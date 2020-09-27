package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.ds_design.BSTIterator;
import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two binary search trees root1 and root2.
 * Return a list containing all the integers from both trees sorted in ascending order.
 * Example 1:
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 */
public class GetAllElementsInTwoBST {

    /**
     * Time O(N)
     * Space O(N)
     * where N are nodes in both trees
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        BSTIterator it1 = new BSTIterator(root1);
        BSTIterator it2 = new BSTIterator(root2);

        Integer val1 = it1.hasNext() ? it1.next() : null;
        Integer val2 = it2.hasNext() ? it2.next() : null;
        do {
            if (val1 != null && val2 != null) {
                if (val1 < val2) {
                    result.add(val1);
                    val1 = it1.hasNext() ? it1.next() : null;
                } else if (val2 < val1) {
                    result.add(val2);
                    val2 = it2.hasNext() ? it2.next() : null;
                } else {
                    result.add(val1);
                    result.add(val2);
                    val1 = it1.hasNext() ? it1.next() : null;
                    val2 = it2.hasNext() ? it2.next() : null;
                }
            } else if (val1 != null) {
                result.add(val1);
                val1 = it1.hasNext() ? it1.next() : null;
            } else if (val2 != null) {
                result.add(val2);
                val2 = it2.hasNext() ? it2.next() : null;
            }
        } while (it1.hasNext() || it2.hasNext() || val1 != null || val2 != null);
        return result;
    }
}
