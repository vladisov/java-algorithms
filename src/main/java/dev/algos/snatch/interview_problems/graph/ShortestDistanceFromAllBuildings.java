package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 */
public class ShortestDistanceFromAllBuildings {

    /**
     * Time O(N * M * houses)
     * Space O(N * M)
     */
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int shortestDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length, housesTotal = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    queue.add(new int[]{index, i, j, 0});
                    String key = index + " " + i + " " + j;
                    visited.add(key);
                    housesTotal++;
                }
                grid[i][j] = -grid[i][j];
            }
        }
        int[][] reach = new int[n][m];
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (var dir : dirs) {
                int i = dir[0] + node[1];
                int j = dir[1] + node[2];
                int cost = node[3];
                int index = node[0];
                String key = index + " " + i + " " + j;
                if (i < 0 || j < 0 || i == n || j == m || grid[i][j] < 0 || visited.contains(key)) continue;
                grid[i][j] += 1 + cost;
                reach[i][j]++;
                queue.add(new int[]{index, i, j, 1 + cost});
                visited.add(key);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 && reach[i][j] == housesTotal) {
                    ans = Math.min(ans, grid[i][j]);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
