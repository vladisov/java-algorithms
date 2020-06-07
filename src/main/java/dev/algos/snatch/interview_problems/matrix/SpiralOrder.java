package dev.algos.snatch.interview_problems.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
class SpiralOrder {

    /**
     * Time O(N * M)
     * Space O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        if (n == 0) {
            return result;
        }

        int m = matrix[0].length;
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = m - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowStart <= rowEnd) { // check one line row
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if (colStart <= colEnd) { // check one line col
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
                colStart++;
            }

        }
        return result;
    }
}
