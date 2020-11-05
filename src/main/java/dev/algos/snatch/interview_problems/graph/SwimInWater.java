package dev.algos.snatch.interview_problems.graph;

import java.util.PriorityQueue;

/**
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
 * Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 * You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?
 * Example 1:
 * Input: [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 */
public class SwimInWater {

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    /**
     * Time O(N^2*logN)
     * Space O(N^2)
     */
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0, 0, grid[0][0]});
        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            int max = node[2];
            for (int[] dir : dirs) {
                int r = dir[0] + i;
                int c = dir[1] + j;
                if (r < 0 || c < 0 || r == n || c == m || visited[r][c]) continue;

                int newMax = Math.max(max, grid[r][c]);
                if (r == n - 1 && c == m - 1) return newMax;
                visited[r][c] = true;
                queue.add(new int[]{r, c, newMax});
            }
        }
        return 0;
    }
}
