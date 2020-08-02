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
    private int[][] dp;
    public NumMatrixOptimized(int[][] matrix) {
        if (matrix.length == 0) return;
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int top = i == 0 ? 0 : dp[i - 1][j];
                int left = j == 0 ? 0 : dp[i][j - 1];
                int corner = i == 0 || j == 0 ? 0 : dp[i - 1][j - 1];
                dp[i][j] = left + top + matrix[i][j] - corner;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp.length == 0) return 0;
        int full = dp[row2][col2];
        int left = col1 == 0 ? 0 : dp[row2][col1 - 1];
        int top = row1 == 0 ? 0 : dp[row1 - 1][col2];
        int corner = row1 == 0 || col1 == 0 ? 0 : dp[row1 - 1][col1 - 1];
        return full - left - top + corner;
    }
}
