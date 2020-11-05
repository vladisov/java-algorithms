package dev.algos.snatch.interview_problems.dp;

/**
 * You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colours: Red, Yellow or Green while making sure that no two adjacent cells have the same colour (i.e no two cells that share vertical or horizontal sides have the same colour).
 * <p>
 * You are given n the number of rows of the grid.
 * <p>
 * Return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 10^9 + 7.
 */
public class NumberOfWaysToPaint3Grid {

    private final int mod = 1000000007;

    /**
     * Time N*3*3*3 and for each state 3^3 loops = N*3^3*3^3 = O(N*27^2)
     * Space O(N*4^3)
     */
    public int numOfWays(int n) {
        return dfs(0, n, 0, 0, 0, new Integer[n][4][4][4]);
    }

    private int dfs(int row, int n, int prevA, int prevB, int prevC, Integer[][][][] dp) {
        if (row == n) return 1;

        if (dp[row][prevA][prevB][prevC] == null) {
            int count = 0;
            /*
            a b c - combination per row
             */
            for (int a = 1; a <= 3; a++) {
                if (a == prevA) continue;
                for (int b = 1; b <= 3; b++) {
                    if (b == a || b == prevB) continue;
                    for (int c = 1; c <= 3; c++) {
                        if (c == b || c == prevC) continue;
                        count += dfs(row + 1, n, a, b, c, dp);
                        count %= mod;
                    }
                }
            }
            dp[row][prevA][prevB][prevC] = count;
        }
        return dp[row][prevA][prevB][prevC];
    }
}
