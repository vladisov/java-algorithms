package dev.algos.snatch.interview_problems.xor;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * <p>
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */
public class FlipImage {

    /**
     * Time O(n) where n is number of elements in matrix
     * Space O(1)
     * <p>
     * https://leetcode.com/problems/flipping-an-image/
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < (A[row].length + 1) / 2; col++) {
                int tmp = A[row][col] ^ 1;
                A[row][col] = A[row][A[row].length - 1 - col] ^ 1;
                A[row][A[row].length - 1 - col] = tmp;
            }
        }
        return A;
    }
}
