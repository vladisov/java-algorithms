package dev.algos.snatch.interview_problems.dp.matrix_dp;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 */
public class CountSubmatricesWithAllOnes {

    /**
     * Time O(N*M)
     * Space O(1)
     */
    public int countSquares(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j - 1])) + 1;
                }
                count += matrix[i][j];
            }
        }
        return count;
    }
}
