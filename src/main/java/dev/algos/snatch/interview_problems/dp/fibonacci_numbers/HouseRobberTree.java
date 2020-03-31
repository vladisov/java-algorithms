package dev.algos.snatch.interview_problems.dp.fibonacci_numbers;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * <p>
 * Input: [3,4,5,1,3,null,1]
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * <p>
 * https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
 */
public class HouseRobberTree {

    /**
     * Time O(N) all nodes
     * Space O(N)
     */
    public int robDp(TreeNode root) {
        //first index - not robbed , second - robbed
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    /**
     * Time O(N) all nodes
     * Space O(N)
     */
    public int robMemo2(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }

    public int rob(TreeNode root) {
        return robRec(root, false, new HashMap<>());
    }

    int robRec(TreeNode root, boolean shouldSkip, Map<TreeNode, Map<Boolean, Integer>> dp) {
        if (root == null) {
            return 0;
        }
        //two choices rob or not rob
        if (!dp.containsKey(root) || !dp.get(root).containsKey(shouldSkip)) {
            int take = 0;
            if (!shouldSkip) {
                take = root.val + robRec(root.left, true, dp) + robRec(root.right, true, dp);
            }
            int skip = robRec(root.left, false, dp) + robRec(root.right, false, dp);

            dp.putIfAbsent(root, new HashMap<>());
            dp.get(root).put(shouldSkip, Math.max(take, skip));
        }
        return dp.get(root).get(shouldSkip);
    }
}
