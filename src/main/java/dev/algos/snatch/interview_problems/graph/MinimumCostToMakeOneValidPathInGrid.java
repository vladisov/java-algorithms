package dev.algos.snatch.interview_problems.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:
 * 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
 * 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
 * 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
 * 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
 * Notice that there could be some invalid signs on the cells of the grid which points outside the grid.
 * <p>
 * You will initially start at the upper left cell (0,0). A valid path in the grid is a path which starts from the upper left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path doesn't have to be the shortest.
 * <p>
 * You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.
 * <p>
 * Return the minimum cost to make the grid have at least one valid path.
 * <p>
 * https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 */
public class MinimumCostToMakeOneValidPathInGrid {

    int[][] dirs = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    /**
     * Time O(NM)
     * Space O(NM)
     */
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int cost = 0;
        Queue<int[]> queue = new LinkedList<>();
        dfs(grid, 0, 0, 0, dp, queue);
        while (!queue.isEmpty()) {
            int size = queue.size();
            cost++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    dfs(grid, cost, curr[0] + dir[0], curr[1] + dir[1], dp, queue);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    private void dfs(int[][] grid, int cost, int i, int j, int[][] dp, Queue<int[]> queue) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || dp[i][j] != Integer.MAX_VALUE) {
            return;
        }
        dp[i][j] = cost;
        queue.add(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(grid, cost, i + dir[0], j + dir[1], dp, queue);
        }
    }
}
