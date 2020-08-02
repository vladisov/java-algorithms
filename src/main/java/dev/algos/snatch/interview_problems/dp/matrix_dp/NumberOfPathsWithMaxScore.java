package dev.algos.snatch.interview_problems.dp.matrix_dp;

import java.util.List;

/**
 * You are given a square board of characters. You can move on the board starting at the bottom right square marked with the character 'S'.
 * <p>
 * You need to reach the top left square marked with the character 'E'. The rest of the squares are labeled either with a numeric character 1, 2, ..., 9 or with an obstacle 'X'. In one move you can go up, left or up-left (diagonally) only if there is no obstacle there.
 * <p>
 * Return a list of two integers: the first integer is the maximum sum of numeric characters you can collect, and the second is the number of such paths that you can take to get that maximum sum, taken modulo 10^9 + 7.
 * <p>
 * In case there is no path, return [0, 0].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: board = ["E23","2X2","12S"]
 * Output: [7,1]
 * Example 2:
 * <p>
 * Input: board = ["E12","1X1","21S"]
 * Output: [4,2]
 * Example 3:
 * <p>
 * Input: board = ["E11","XXX","11S"]
 * Output: [0,0]
 */
public class NumberOfPathsWithMaxScore {

    int mod = 1000000007;
    int[][] dirs = new int[][]{{1, 1}, {0, 1}, {1, 0}};

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int[] pathsWithMaxScore(List<String> board) {
        int[][][] grid = preprocess(board);
        int n = grid.length;
        dp(grid);
        if (grid[0][0][0] == -1) {
            return new int[]{0, 0};
        }
        return new int[]{grid[0][0][0], grid[0][0][1]};
    }

    private int[][][] preprocess(List<String> board) {
        int n = board.size();
        int[][][] grid = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board.get(i).charAt(j);
                grid[i][j][0] = Character.isDigit(c) ? c - '0' : -1;
            }
        }
        grid[0][0][0] = grid[n - 1][n - 1][0] = 0;
        grid[n - 1][n - 1][1] = 1;
        return grid;
    }

    private void dp(int[][][] grid) {
        int n = grid.length;
        for (int i = n - 2; i >= 0; i--) {
            if (grid[n - 1][i + 1][0] == -1) {
                grid[n - 1][i][0] = grid[n - 1][i + 1][0];
            } else {
                grid[n - 1][i][0] += grid[n - 1][i + 1][0];
            }
            grid[n - 1][i][1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (grid[i + 1][n - 1][0] == -1) {
                grid[i][n - 1][0] = grid[i + 1][n - 1][0];
            } else {
                grid[i][n - 1][0] += grid[i + 1][n - 1][0];
            }
            grid[i][n - 1][1] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (grid[i][j][0] == -1) continue;
                int max = -1, count = 0;
                for (int[] dir : dirs) {
                    int x = dir[0] + i;
                    int y = dir[1] + j;
                    if (grid[x][y][0] != -1) {
                        if (grid[x][y][0] > max) {
                            max = grid[x][y][0];
                            count = grid[x][y][1];
                        } else if (grid[x][y][0] == max) {
                            count += grid[x][y][1];
                        }
                    }
                }
                if (max != -1) {
                    grid[i][j][0] += max % mod;
                    grid[i][j][1] = count % mod;
                } else {
                    grid[i][j][0] = -1;
                }
            }
        }
    }
}
