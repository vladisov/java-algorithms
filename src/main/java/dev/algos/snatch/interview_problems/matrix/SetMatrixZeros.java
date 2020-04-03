package dev.algos.snatch.interview_problems.matrix;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * Example 2:
 * <p>
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * Follow up:
 * <p>
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeros {

    /**
     * Time O(N * M)
     * Space O(1)
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return;
        }
        boolean fRow = false, fCol = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fRow = true;
                    if (j == 0) fCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (fCol) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        if (fRow) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
