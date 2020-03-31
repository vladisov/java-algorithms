package dev.algos.snatch.interview_problems.prefix_sum;

/**
 * Time O(nm)
 * Space O(n)
 */
class NumMatrix {

    int[][] matrix;
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        this.matrix = matrix;
        this.sum = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                sum[i][j] = sum[i][j - 1] + matrix[i][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrix.length == 0) {
            return 0;
        }
        int currSum = 0;
        for (int i = row1; i <= row2; i++) {
            currSum += sum[i][col2 + 1] - sum[i][col1];
        }
        return currSum;
    }
}

/**
 * Time O(nm)
 * Space O(1)
 */
class NumMatrixOptimized {
    private int[][] sumRegion;

    public NumMatrixOptimized(int[][] matrix) {
        if (matrix.length != 0) sumRegion = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                sumRegion[i + 1][j + 1] = sum + sumRegion[i][j + 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion[row2 + 1][col2 + 1] - sumRegion[row1][col2 + 1] - sumRegion[row2 + 1][col1] + sumRegion[row1][col1];
    }
}
