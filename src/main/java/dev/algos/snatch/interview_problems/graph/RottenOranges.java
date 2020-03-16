package dev.algos.snatch.interview_problems.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    /**
     * Time complexity O(n) if n is number of elements otherwise time and space is (n * m)
     * Space complexity O(n)
     */
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dirs = new int[][]{
                {-1, 0},
                {1, 0},
                {0, 1},
                {0, -1}
        };
        int lvl = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] rotten = queue.poll();
                for (int[] dir : dirs) {
                    int i = rotten[0] + dir[0];
                    int j = rotten[1] + dir[1];
                    if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length ||
                            grid[i][j] == 0 || grid[i][j] == 2) continue;
                    grid[i][j] = 2;
                    fresh--;
                    queue.add(new int[]{i, j});
                }
            }
            if (!queue.isEmpty()) {
                lvl++;
            }
        }
        if (fresh != 0) {
            return -1;
        }
        return lvl;
    }
}
