package dev.algos.snatch.interview_problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * Example 1:
 * Input:
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 */
public class ZeroOneMatrix {

    /**
     * Time O(N*M)
     * Space O(N*M)
     */
    public int[][] updateMatrix(int[][] matrix) {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Point(i, j));
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[][] dirs = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var point = queue.poll();
                for (int[] dir : dirs) {
                    int row = dir[0] + point.x;
                    int col = dir[1] + point.y;
                    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length
                            || matrix[row][col] >= 0) continue;
                    matrix[row][col] = 1 + matrix[point.x][point.y];
                    queue.add(new Point(row, col));
                }
            }
        }

        return matrix;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
