package dev.algos.snatch.interview_problems.dp.fibonacci_numbers;

/**
 * Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’ as the sum of 1, 3, or 4.
 * <p>
 * Example 1:
 * <p>
 * n : 4
 * Number of ways = 4
 * Explanation: Following are the four ways we can exoress 'n' : {1,1,1,1}, {1,3}, {3,1}, {4}
 * Example 2:
 * <p>
 * n : 5
 * Number of ways = 6
 * Explanation: Following are the six ways we can express 'n' : {1,1,1,1,1}, {1,1,3}, {1,3,1}, {3,1,1},
 * {1,4}, {4,1}
 */
public class NumberFactors {

    /**
     * Time O(N)
     * Space O(1)
     */
    public int countWaysDpOptimized(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int f = 1, sec = 1, th = 1, fo = 2;
        for (int i = 4; i <= n; i++) {
            int tmp = f + sec + fo;
            f = sec;
            sec = th;
            th = fo;
            fo = tmp;
        }

        return fo;
    }

    /**
     * Time O(N)
     * Space O(N)
     */
    public int countWaysDp(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];

        return dp[n];
    }

    public int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        return countWays(n - 1) + countWays(n - 3) + countWays(n - 4);
    }
}
