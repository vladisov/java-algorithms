package dev.algos.snatch.interview_problems.dp;

public class OutOfBoundaryPath {

    int mod = 1_000_000_007;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int findPaths(int n, int m, int N, int i, int j) {
        return findPathsHelper(n, m, N, i, j, new Integer[n][m][N + 1]);
    }

    /**
     * Time O(nmN)
     * Space O(nmN)
     */
    public int findPathsHelper(int n, int m, int N, int i, int j, Integer[][][] dp) {
        if (i < 0 || j < 0 || i == n || j == m) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        if (dp[i][j][N] == null) {
            int count = 0;
            for (int[] dir : dirs) {
                count += (findPathsHelper(n, m, N - 1, i + dir[0], j + dir[1], dp) % mod);
                count %= mod;
            }
            dp[i][j][N] = count % mod;
        }
        return dp[i][j][N];
    }


    /*
    4 2
    2 2

     */
    public int findPathsBottomUp(int n, int m, int N, int i, int j) {
        int[][][] dp = new int[n][m][N + 1];

        for (int step = 1; step <= N; step++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    for (int[] dir : dirs) {
                        int x = dir[0] + row;
                        int y = dir[1] + col;
                        if (x < 0 || y < 0 || x == n || y == m) {
                            dp[row][col][step]++;
                            dp[row][col][step] %= mod;
                        } else {
                            dp[row][col][step] += (dp[x][y][step - 1] % mod);
                        }
                    }
                }
            }
        }
        return dp[i][j][N];
    }

    /**
     * Time O(nmN)
     * Space O(nm)
     */
    public int findPathsBottomUpOptimized(int n, int m, int N, int i, int j) {
        int[][] dp = new int[n][m];
        for (int step = 1; step <= N; step++) {
            int[][] next = new int[n][m];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    for (int[] dir : dirs) {
                        int x = dir[0] + row;
                        int y = dir[1] + col;
                        if (x < 0 || y < 0 || x == n || y == m) {
                            next[row][col]++;
                            next[row][col] %= mod;
                        } else {
                            next[row][col] += (dp[x][y] % mod);
                        }
                    }
                }
            }
            dp = next;
        }
        return dp[i][j];
    }
}
