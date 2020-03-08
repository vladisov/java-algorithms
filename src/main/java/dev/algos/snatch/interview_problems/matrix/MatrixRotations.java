package dev.algos.snatch.interview_problems.matrix;

import java.util.List;

//TODO https://www.hackerrank.com/challenges/matrix-rotation-algo/
public class MatrixRotations {
    void matrixRotation(List<List<Integer>> matrix, int r) {
        if (matrix == null || matrix.isEmpty() || r == 0) return;
        int n = matrix.size();
        for (int i = 0; i < matrix.size() / 2; i++) {
            int[][] indices = buildRotationIndices(matrix, i, i, n - (i * 2), matrix.get(i).size() - (i * 2));
            int maxRotations = indices.length;
            int rotations = r;
            if (r > maxRotations)
                rotations = maxRotations % r;
            Integer prev = null;
            for (int j = 0; j < indices.length; j++) {
                int[] index = indices[j];
                int nextIndex = j + rotations;
                if (nextIndex >= indices.length) {
                    nextIndex = nextIndex - indices.length;
                }
                int[] next = indices[nextIndex];
                int nextEl = matrix.get(next[0]).get(next[1]);

                if (prev == null) {
                    matrix.get(next[0]).set(next[1], matrix.get(index[0]).get(index[1]));
                } else {
                    matrix.get(next[0]).set(next[1], prev);
                }
                prev = nextEl;
            }
        }
    }

    private int[][] buildRotationIndices(List<List<Integer>> matrix, int row,
                                         int col, int n, int m) {
        //should be finalized
        int[][] arr = new int[((n - 1) + (m - 1)) * 2][2];
        int k = 0;
        for (int i = 0; i < n - 1; i++) {
            arr[k][0] = row + i;
            arr[k++][1] = col;
        }
        for (int i = 0; i < n - 1; i++) {
            arr[k][0] = row + n - 1;
            arr[k++][1] = col + i;
        }
        for (int i = 0; i < n - 1; i++) {
            arr[k][0] = row + n - 1 - i;
            arr[k++][1] = col + m - 1;
        }
        for (int i = 0; i < n - 1; i++) {
            arr[k][0] = row;
            arr[k++][1] = col + m - 1 - i;
        }
        return arr;
    }
}
