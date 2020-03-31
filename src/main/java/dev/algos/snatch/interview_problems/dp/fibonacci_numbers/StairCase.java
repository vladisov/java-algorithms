package dev.algos.snatch.interview_problems.dp.fibonacci_numbers;

/**
 * Problem Statement #
 * Given a stair with ‘n’ steps, implement a method to count how many possible ways are there to reach the top of the staircase,
 * given that, at every step you can either take 1 step, 2 steps, or 3 steps.
 * <p>
 * Example 1:
 * <p>
 * Number of stairs (n) : 3
 * Number of ways = 4
 * Explanation: Following are the four ways we can climb : {1,1,1}, {1,2}, {2,1}, {3}
 * Example 2:
 * <p>
 * Number of stairs (n) : 4
 * Number of ways = 7
 * Explanation: Following are the seven ways we can climb : {1,1,1,1}, {1,1,2}, {1,2,1}, {2,1,1},
 * {2,2}, {1,3}, {3,1}
 */
public class StairCase {

    /**
     * Time O(N)
     * Space O(1)
     */
    int countStairsDpOptimized(int n) {
        int first = 1;
        int second = 1;
        int third = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = first + second + third;
            first = second;
            second = third;
            third = tmp;
        }
        return third;
    }

    /**
     * Time O(3^N)
     * Space O(N)
     */
    int countStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        return countStairs(n - 1) + countStairs(n - 2) + countStairs(n - 3);
    }

    /**
     * Time O(N)
     * Space O(N)
     */
    int countStairsDp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
