package dev.algos.snatch.interview_problems.dp;

/**
 * There are several stones arranged in a row, and each stone has an associated value which is an integer given in the array stoneValue.
 * In each round of the game, Alice divides the row into two non-empty rows (i.e. left row and right row), then Bob calculates the value of each row which is the sum of the values of all the stones in this row. Bob throws away the row which has the maximum value, and Alice's score increases by the value of the remaining row. If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away. The next round starts with the remaining row.
 * The game ends when there is only one stone remaining. Alice's is initially zero.
 * Return the maximum score that Alice can obtain.
 * Example 1:
 * Input: stoneValue = [6,2,3,4,5,5]
 * Output: 18
 * Explanation: In the first round, Alice divides the row to [6,2,3], [4,5,5]. The left row has the value 11 and the right row has value 14. Bob throws away the right row and Alice's score is now 11.
 * In the second round Alice divides the row to [6], [2,3]. This time Bob throws away the left row and Alice's score becomes 16 (11 + 5).
 * The last round Alice has only one choice to divide the row which is [2], [3]. Bob throws away the right row and Alice's score is now 18 (16 + 2). The game ends because only one stone is remaining in the row.
 */
public class StoneGame_V {

    /**
     * Time O(N^3)
     * Space O(N^2)
     */
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] sum = new int[n];
        sum[0] = stoneValue[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = stoneValue[i] + sum[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(0, n - 1, sum, dp);
    }

    private int helper(int lo, int hi, int[] sum, int[][] dp) {
        if (lo == hi) {
            return 0;
        }
        if (dp[lo][hi] == -1) {
            int ans = 0;
            for (int mid = lo; mid <= hi - 1; mid++) {
                int left = sum[mid] - (lo == 0 ? 0 : sum[lo - 1]);
                int right = sum[hi] - sum[mid];
                if (left == right) {
                    ans = Math.max(Math.max(left + helper(lo, mid, sum, dp), left + helper(mid + 1, hi, sum, dp)), ans);
                } else {
                    int leftIndex, rightIndex;
                    if (left < right) {
                        leftIndex = lo;
                        rightIndex = mid;
                    } else {
                        leftIndex = mid + 1;
                        rightIndex = hi;
                    }
                    ans = Math.max(Math.min(left, right) + helper(leftIndex, rightIndex, sum, dp), ans);
                }
            }
            dp[lo][hi] = ans;
        }
        return dp[lo][hi];
    }
}
