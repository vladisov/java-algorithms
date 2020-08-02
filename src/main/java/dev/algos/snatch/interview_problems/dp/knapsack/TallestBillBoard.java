package dev.algos.snatch.interview_problems.dp.knapsack;

/**
 * You are installing a billboard and want it to have the largest height.  The billboard will have two steel supports, one on each side.  Each steel support must be an equal height.
 * <p>
 * You have a collection of rods which can be welded together.  For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.
 * <p>
 * Return the largest possible height of your billboard installation.  If you cannot support the billboard, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,6]
 * Output: 6
 * Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: 10
 * Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.
 * Example 3:
 * <p>
 * Input: [1,2]
 * Output: 0
 * Explanation: The billboard cannot be supported, so we return 0.
 */
public class TallestBillBoard {

    /**
     * Time O(N*S)
     * Space O(N*S)
     */
    public int tallestBillboard(int[] rods) {
        return helper(rods, 0, 0, 0, new Integer[rods.length + 1][5001]);
    }

    private int helper(int[] rods, int i, int sum1, int sum2, Integer[][] dp) {

        int delta = Math.abs(sum1 - sum2);
        if (dp[i][delta] != null) {
            return dp[i][delta] == -1 ? -1 : dp[i][delta] + Math.max(sum1, sum2);
        }

        if (i == rods.length) {
            return sum1 == sum2 ? sum1 : -1;
        }

        int m1 = helper(rods, i + 1, sum1 + rods[i], sum2, dp);
        int m2 = helper(rods, i + 1, sum1, sum2, dp);
        int m3 = helper(rods, i + 1, sum1, sum2 + rods[i], dp);

        int max = Math.max(m1, Math.max(m2, m3));

        int toAdd = max - Math.max(sum1, sum2);

        dp[i][delta] = max == -1 ? -1 : toAdd;
        return max;
    }
}
