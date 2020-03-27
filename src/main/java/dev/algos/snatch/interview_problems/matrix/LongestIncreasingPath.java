package dev.algos.snatch.interview_problems.matrix;

import java.util.Arrays;

public class LongestIncreasingPath {

    private static int[][] dirs = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    /**
     * Time O(V^2)
     * Space O(V^2)
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int[][] paths = new int[n][matrix[0].length];
        for (int i = 0; i < n; i++) {
            Arrays.fill(paths[i], -1);
        }

        int maxPath = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxPath = Math.max(longestIncreasingPath(i, j, matrix, paths), maxPath);
            }
        }
        return maxPath;
    }

    private int longestIncreasingPath(int i, int j, int[][] matrix, int[][] paths) {
        if (paths[i][j] != -1) {
            return paths[i][j];
        }
        int max = 1;
        for (int[] dir : dirs) {
            int[] next = new int[]{dir[0] + i, dir[1] + j};
            if (next[0] < 0 || next[0] >= matrix.length || next[1] < 0 || next[1] >= matrix[next[0]].length
                    || matrix[next[0]][next[1]] <= matrix[i][j]) {
                continue;
            }
            int path = 1 + longestIncreasingPath(next[0], next[1], matrix, paths);
            max = Math.max(path, max);
        }
        paths[i][j] = max;
        return max;
    }
}
