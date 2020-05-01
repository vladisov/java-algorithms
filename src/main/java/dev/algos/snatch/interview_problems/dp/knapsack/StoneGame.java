package dev.algos.snatch.interview_problems.dp.knapsack;

/**
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * <p>
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 * <p>
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
 * <p>
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [5,3,4,5]
 * Output: true
 * Explanation:
 * Alex starts first, and can only take the first 5 or the last 5.
 * Say he takes the first 5, so that the row becomes [3, 4, 5].
 * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
 * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 */
public class StoneGame {

    /**
     * Time O(2^N) for non recursive and O(N^2)?? for recursive
     * Space O(N^2)
     */
    public boolean stoneGame(int[] piles) {
        int start = 0, end = piles.length - 1;
        Integer[][][] dp = new Integer[piles.length][piles.length][2];
        return (stoneGameRec(piles, start, end, 1, dp) >= 0);
    }

    private int stoneGameRec(int[] piles, int start, int end, int id, Integer[][][] dp) {
        if (end < start) {
            return 0;
        }
        id = Math.abs(id - 1);
        if (dp[start][end][id] == null) {
            if (id == 1) {
                dp[start][end][id] = Math.max(piles[start] + stoneGameRec(piles, start + 1, end, id, dp),
                        piles[end] + stoneGameRec(piles, start, end - 1, id, dp));
            } else {
                dp[start][end][id] = Math.min(-piles[start] + stoneGameRec(piles, start + 1, end, id, dp),
                        -piles[end] + stoneGameRec(piles, start, end - 1, id, dp));
            }
        }
        return dp[start][end][id];
    }

    public boolean stoneGameDP(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        boolean turn = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (turn) {
                    dp[i][j] = Math.max(piles[i] + dp[i + 1][j], piles[j] + dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.max(-piles[i] + dp[i + 1][j], -piles[j] + dp[i][j - 1]);
                }
                turn = !turn;
            }
        }
        return dp[0][n - 1] >= 0;
    }

    /*

     */
}
