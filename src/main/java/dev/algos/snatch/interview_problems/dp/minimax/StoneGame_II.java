package dev.algos.snatch.interview_problems.dp.minimax;


/**
 * Alex and Lee continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.
 * <p>
 * Alex and Lee take turns, with Alex starting first.  Initially, M = 1.
 * <p>
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
 * <p>
 * The game continues until all the stones have been taken.
 * <p>
 * Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 piles again.
 * Alex can get 2 + 4 + 4 = 10 piles in total. If Alex takes two piles at the beginning, then Lee can take all three piles left.
 * In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since it's larger.
 */
public class StoneGame_II {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int stoneGameII(int[] piles) {
        int total = 0;
        for (int pile : piles) {
            total += pile;
        }
        Integer[][][] dp = new Integer[piles.length][2][piles.length];
        return total + helper(piles, 1, 0, 0, dp);
    }

    private int helper(int[] piles, int m, int index, int id, Integer[][][] dp) {
        if (index == piles.length) {
            return 0;
        }
        id = Math.abs(id - 1);
        if (dp[index][id][m] == null) {
            int endIndex = Math.min(piles.length, index + 2 * m);
            if (id == 1) {
                int max = Integer.MIN_VALUE;
                for (int i = index; i < endIndex; i++) {
                    int taken = Math.max(m, i - index + 1);
                    max = Math.max(max, helper(piles, taken, i + 1, id, dp));
                }
                dp[index][id][m] = max;
            } else {
                int min = Integer.MAX_VALUE, sum = 0;
                for (int i = index; i < endIndex; i++) {
                    int taken = Math.max(m, i - index + 1);
                    sum -= piles[i];
                    min = Math.min(min, sum + helper(piles, taken, i + 1, id, dp));
                }
                dp[index][id][m] = min;
            }
        }
        return dp[index][id][m];
    }
}
