package dev.algos.snatch.interview_problems.matrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 */
public class SearchIn2DMatrix_II {

    /**
     * Time O(N+M)
     * Space O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m - 1;
        while (col >= 0 && row < n) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
