package dev.algos.snatch.interview_problems.matrix;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * Example:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 */
public class DiagonalTraverse {

    /**
     * Time O(N*M)
     * Space O(1)
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int n = matrix.length, m = matrix[0].length, row = 0, col = 0, index = 0;
        int[] res = new int[m * n];
        boolean right = true;
        while (col < m && row < n) {
            int i = row, j = col, size = Math.min(n - i, j + 1);
            if (right) {
                index += size - 1;
                while (i < n && j >= 0) res[index--] = matrix[i++][j--];
                index += size + 1;
                right = false;
            } else {
                while (i < n && j >= 0) res[index++] = matrix[i++][j--];
                right = true;
            }
            if (row == 0) {
                col++;
                if (col == m) {
                    col = m - 1;
                    row++;
                }
            } else {
                row++;
            }
        }
        return res;
    }
}
