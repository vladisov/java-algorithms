package dev.algos.snatch.interview_problems.dp.fibonacci_numbers;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 */
class MinCostClimbingStairs {

    /**
     * Time O(N)
     * Space O(1)
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1) {
            return 0;
        }
        int first = cost[0];
        int sec = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int third = Math.min(first + cost[i], sec + cost[i]);
            first = sec;
            sec = third;
        }
        return Math.min(sec, first);
    }

    public int minCostClimbingStairsMemo(int[] cost) {
        Integer[] dp = new Integer[cost.length];
        return Math.min(minCostRec(cost, 0, dp), minCostRec(cost, 1, dp));
    }

    private int minCostRec(int[] cost, int index, Integer[] dp) {
        if (index >= cost.length) {
            return 0;
        }
        if (dp[index] == null) {
            int cost1 = cost[index] + minCostRec(cost, index + 1, dp);
            int cost2 = cost[index] + minCostRec(cost, index + 2, dp);
            dp[index] = Math.min(cost1, cost2);
        }
        return dp[index];
    }
}
