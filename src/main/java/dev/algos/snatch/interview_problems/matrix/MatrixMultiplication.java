package dev.algos.snatch.interview_problems.matrix;

public class MatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int m = A[0].length, n = A.length, l = B[0].length;
        int[][] C = new int[n][l];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                for (int k = 0; k < m; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public int[][] multiply1(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }
}
