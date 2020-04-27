package dev.algos.snatch.interview_problems.dp.matrix_dp;

public class MaximalSquare {

    /**
     * Time O(N*M)
     * Space O(N*M)
     */
    int solveMatrix(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    max = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int dia = dp[i - 1][j - 1];
                int left = dp[i - 1][j];
                int right = dp[i][j - 1];
                int curr = dp[i][j];
                if (dia > 0 && left > 0 && right > 0 && curr > 0) {
                    int min = Math.min(dia, Math.min(left, right));
                    int minSqrt = (int) Math.sqrt(min);
                    dp[i][j] = 1 + min + minSqrt * 2;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
