package dev.algos.snatch.interview_problems.dp.matrix_dp;

/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * <p>
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * <p>
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * <p>
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * <p>
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * <p>
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 */
public class DungeonGame {

    /**
     * Time O(N*M)
     * Space O(N*M)
     * <p>
     * For the route itself start and end are reversible, but the information needed is different.
     * When going forwards current hp and minimum hp are both useful information.
     * When going backwards, current hp is useless as if it's larger than minimum,
     * then it's an inevitable hp overflow;
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = Math.max(0, -dungeon[n - 1][m - 1]); // initial health that knight needed
        for (int i = n - 2; i >= 0; i--) {
            //don't fall below 0
            dp[i][m - 1] = Math.max(0, dp[i + 1][m - 1] - dungeon[i][m - 1]);
        }
        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1][i] = Math.max(0, dp[n - 1][i + 1] - dungeon[n - 1][i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = Math.max(0, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0] + 1;
    }
}
