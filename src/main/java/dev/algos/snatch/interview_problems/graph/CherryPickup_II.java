package dev.algos.snatch.interview_problems.graph;

public class CherryPickup_II {

    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        return grid[0][0] + grid[0][m - 1] + helper(grid, 0, 0, m - 1, new Integer[n][m][m]);
    }

    int helper(int[][] grid, int row, int c1, int c2, Integer[][][] dp) {
        int n = grid.length, m = grid[0].length;
        if (row == n) {
            return 0;
        }

        if (dp[row][c1][c2] == null) {
            int max = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nr = row + 1;
                    int nc1 = c1 + i;
                    int nc2 = c2 + j;
                    if (nc1 < m && nc2 < m && nc1 >= 0 && nc2 >= 0 && nr >= 0 && nr < n) {
                        int sum = nc1 == nc2 ? grid[nr][nc1] : grid[nr][nc1] + grid[nr][nc2];
                        max = Math.max(sum + helper(grid, nr, nc1, nc2, dp), max);
                    }
                }
            }
            dp[row][c1][c2] = max;
        }
        return dp[row][c1][c2];
    }
}
