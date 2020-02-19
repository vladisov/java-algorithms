package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.LinkedList;
import java.util.List;

//TODO desc
public class CountPathsForSum {

    /**
     * Time complexity O(n^2)
     * Space complexity O(n)
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return pathSum(root, sum, new LinkedList<>());
    }

    private int pathSum(TreeNode root, int sum, List<Integer> currPath) {
        if (root == null) return 0;

        currPath.add(root.val);

        int pathCount = 0, pathSum = 0;
        for (int i = currPath.size() - 1; i >= 0; i--) {
            pathSum += currPath.get(i);
            if (pathSum == sum) {
                pathCount++;
            }
        }

        pathCount += pathSum(root.left, sum, currPath);
        pathCount += pathSum(root.right, sum, currPath);

        currPath.remove(currPath.size() - 1);

        return pathCount;
    }
}
