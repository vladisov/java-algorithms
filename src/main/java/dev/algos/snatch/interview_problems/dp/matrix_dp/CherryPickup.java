package dev.algos.snatch.interview_problems.dp.matrix_dp;

public class CherryPickup {

    int[][] dirs = {{0, 1}, {1, 0,}};

    /*
    {1,  1,  1, 1,  1},
    {1,  1, -1, 1,  1},
    {-1, -1, 1, 1,  1},
    {1,  1,  1, 1,  1},
    {-1, 1,  1, 1,  1 }

    {1, 1, 1, 1, 0, 0, 0},
    {0, 0, 0, 1, 0, 0, 0},
    {0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 1, 0, 0, 0},
    {0, 0, 0, 1, 0, 0, 0},
    {0, 0, 0, 1, 0, 0, 0},
    {0, 0, 0, 1, 1, 1, 1}}));

     */

    public static void main(String[] args) {
        CherryPickup cherryPickup = new CherryPickup();
        System.out.println(cherryPickup.cherryPickup(new int[][]{{1, 1, 1, 1, 1}, {1, 1, -1, 1, 1}, {-1, -1, 1, 1, 1}, {1, 1, 1, 1, 1}, {-1, 1, 1, 1, 1}}));
        System.out.println(cherryPickup.cherryPickup(new int[][]{{1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1}}));
        System.out.println(cherryPickup.cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}));
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int ans = dfsOptimized(0, 0, 0, grid, new Integer[n][n][n][n]);
        return ans == -1 ? 0 : ans;
    }

    private int dfs(int i, int j, int x, int y, int[][] grid, Integer[][][][] dp) {
        int n = grid.length;
        if (noGo(i, j, x, y, grid)) {
            return -1;
        }
        if (dp[i][j][x][y] != null) return dp[i][j][x][y];
        if (i == n - 1 && j == n - 1 && x == n - 1 && y == n - 1) return dp[i][j][x][y] = grid[i][j];
        int current = i == x && j == y ? grid[i][j] : grid[i][j] + grid[x][y];
        int max = -1;
        for (var dir : dirs) {
            for (var dir1 : dirs) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                int nextX = x + dir1[0];
                int nextY = y + dir1[1];
                int path = dfs(nextI, nextJ, nextX, nextY, grid, dp);
                if (path == -1) continue;
                max = Math.max(max, path + current);
            }
        }
        return dp[i][j][x][y] = max;
    }

    private int dfsOptimized(int i, int j, int y, int[][] grid, Integer[][][][] dp) {
        int n = grid.length;
        int x = i + Math.abs(y - j);
        if (noGo(i, j, x, y, grid)) {
            return -1;
        }
        if (dp[i][j][x][y] != null) return dp[i][j][x][y];
        if (i == n - 1 && j == n - 1 && x == n - 1 && y == n - 1) return dp[i][j][x][y] = grid[i][j];
        int current = i == x && j == y ? grid[i][j] : grid[i][j] + grid[x][y];
        int max = -1;
        for (var dir : dirs) {
            for (var dir1 : dirs) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                int nextY = y + dir1[1];
                int path = dfsOptimized(nextI, nextJ, nextY, grid, dp);
                if (path == -1) continue;
                max = Math.max(max, path + current);
            }
        }
        return dp[i][j][x][y] = max;
    }

    private boolean noGo(int i, int j, int x, int y, int[][] grid) {
        int n = grid.length;
        return i < 0 || j < 0 || i == n || j == n || x < 0 || y < 0 || x >= n || y >= n || grid[i][j] == -1 || grid[x][y] == -1;
    }

}
