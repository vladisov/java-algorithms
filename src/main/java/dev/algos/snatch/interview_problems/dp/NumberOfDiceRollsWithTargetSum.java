package dev.algos.snatch.interview_problems.dp;

/**
 * You have d dice, and each die has f faces numbered 1, 2, ..., f.
 * <p>
 * Return the number of possible ways (out of fd total ways) modulo 10^9 + 7
 * to roll the dice so the sum of the face up numbers equals target.
 * Example 1:
 * <p>
 * Input: d = 1, f = 6, target = 3
 * Output: 1
 * Explanation:
 * You throw one die with 6 faces.  There is only one way to get a sum of 3.
 */
public class NumberOfDiceRollsWithTargetSum {


    /**
     * Tow down
     * Time O(D*F*T)
     * Space O(D*T)
     */
    public int numRollsToTarget(int d, int f, int target) {
        return numRollsToTargetRec(d, f, target, new Integer[d + 1][target + 1]);
    }

    public int numRollsToTargetRec(int d, int f, int target, Integer[][] memo) {
        if (d == 0) {
            return target == 0 ? 1 : 0;
        }
        if (memo[d][target] == null) {
            int count = 0;
            for (int i = 1; i <= f; i++) {
                if (target >= i) {
                    count = (count + numRollsToTargetRec(d - 1, f, target - i, memo)) % 1000000007;
                } else {
                    break;
                }
            }
            memo[d][target] = count;
        }
        return memo[d][target];
    }

    /**
     * Bottom UP
     * Time O(D*F*T)
     * Space O(D*T)
     */
    public int numRollsToTargetBU(int d, int f, int target) {
        int MOD = 1000000007;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f && k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
        }
        return dp[d][target];
    }
}
