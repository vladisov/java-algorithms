package dev.algos.snatch.interview_problems.matrix;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class SpiralOrder_II {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int element = 1;
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        while (rowStart <= rowEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                arr[rowStart][i] = element++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                arr[i][colEnd] = element++;
            }
            colEnd--;
            if (colStart <= colEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    arr[rowEnd][i] = element++;
                }
                rowEnd--;
            }
            if (rowStart <= rowEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    arr[i][colStart] = element++;
                }
                colStart++;
            }
        }
        return arr;
    }
}
