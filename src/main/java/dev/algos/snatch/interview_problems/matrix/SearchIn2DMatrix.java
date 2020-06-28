package dev.algos.snatch.interview_problems.matrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class SearchIn2DMatrix {

    /**
     * Time O(logNM)
     * Space O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int lo = 0, hi = n * m - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midIndex = mid % m;
            int arrIndex = mid / m;
            if (matrix[arrIndex][midIndex] == target) return true;
            if (matrix[arrIndex][midIndex] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
