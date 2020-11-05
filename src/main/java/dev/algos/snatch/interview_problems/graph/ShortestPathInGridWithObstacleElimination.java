package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In one step, you can move up, down, left or right from and to an empty cell.
 * <p>
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m-1, n-1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 * Example 1:
 * <p>
 * Input:
 * grid =
 * [[0,0,0],
 * [1,1,0],
 * [0,0,0],
 * [0,1,1],
 * [0,0,0]],
 * k = 1
 * Output: 6
 * Explanation:
 * The shortest path without eliminating any obstacle is 10.
 * The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 */
public class ShortestPathInGridWithObstacleElimination {

    /**
     * Time O(nmk)
     * Space O(nmk)
     */
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                if (node[0] == n - 1 && node[1] == m - 1) return len;
                for (var dir : dirs) {
                    int x = dir[0] + node[0], y = dir[1] + node[1], z = node[2];
                    if (x < 0 || y < 0 || x == n || y == m || visited[x][y][z] || (grid[x][y] == 1 && z == k)) continue;
                    visited[x][y][z] = true;
                    z = grid[x][y] == 1 ? z + 1 : z;
                    queue.add(new int[]{x, y, z});
                }
            }
            len++;
        }
        return -1;
    }
}
