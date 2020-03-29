package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    int[][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };

    public int shortestDistance(int[][] grid) {
        int min = Integer.MAX_VALUE;
        //convert
        List<int[]> houses = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
                grid[i][j] *= -1;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    min = Math.min(min, getDistance(grid, i, j, houses));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    int getDistance(int[][] grid, int i, int j, List<int[]> houses) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[grid.length][grid[i].length];
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int distance = dist[curr[0]][curr[1]];
            for (int[] dir : dirs) {
                int[] next = new int[]{curr[0] + dir[0], curr[1] + dir[1]};
                if (isWayToGo(next, dist, i, j, grid)) {
                    dist[next[0]][next[1]] = distance + 1;
                    queue.add(next);
                }
            }
        }

        int distance = 0;
        for (int[] house : houses) {
            distance += dist[house[0]][house[1]];
        }
        return distance;
    }

    boolean isWayToGo(int[] next, int[][] dist, int i, int j, int[][] grid) {
        return next[0] != i && next[1] != j && next[0] >= 0 && next[0] < grid.length &&
                next[1] >= 0 && next[1] < grid[next[0]].length && grid[next[0]][next[1]] != -2
                && grid[next[0]][next[1]] != -1 && dist[next[0]][next[1]] == 0;
    }
}
