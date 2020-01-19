package dev.algos.snatch.interview_problems.gss;

class DiagonalTraverse {

    int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int row = 0;
        int column = 0;
        int direction = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[n * m];

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][column];
            row -= direction;
            column += direction;

            if (row >= m) {
                row = m - 1;
                column += 2;
                direction = -direction;
            }
            if (column >= n) {
                column = n - 1;
                row += 2;
                direction = -direction;
            }
            if (row < 0) {
                row = 0;
                direction = -direction;
            }
            if (column < 0) {
                column = 0;
                direction = -direction;
            }
        }
        return result;
    }
}
