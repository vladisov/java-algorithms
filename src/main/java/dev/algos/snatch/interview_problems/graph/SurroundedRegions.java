package dev.algos.snatch.interview_problems.graph;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {

    int[][] dirs = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    /**
     * Time O(N*M)
     * Space O(1)
     */
    public void solve(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O') {
                dfs(grid, i, 0);
            }
            if (grid[i][m - 1] == 'O') {
                dfs(grid, i, m - 1);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 'O') {
                dfs(grid, 0, i);
            }
            if (grid[n - 1][i] == 'O') {
                dfs(grid, n - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
                if (grid[i][j] == '*') {
                    grid[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] != 'O') return;
        grid[i][j] = '*';
        for (var dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
