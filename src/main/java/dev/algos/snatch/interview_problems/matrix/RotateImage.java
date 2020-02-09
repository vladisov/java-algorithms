package dev.algos.snatch.interview_problems.matrix;

/**
 * You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
 * <p>
 * Example
 * <p>
 * For
 * <p>
 * a = [[1, 2, 3],
 * [4, 5, 6],
 * [7, 8, 9]]
 * the output should be
 * <p>
 * rotateImage(a) =
 * [[7, 4, 1],
 * [8, 5, 2],
 * [9, 6, 3]]
 */
public class RotateImage {


    public int[][] rotateImage(int[][] a) {
        int n = a.length, offSet = a.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < offSet; col++) {
                int tmp = a[row][col];
                a[row][col] = a[n - 1 - col][n - 1 - row];
                a[n - 1 - col][n - 1 - row] = tmp;
            }
            offSet--;
        }
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = tmp;
        }
        return a;
    }

    public int[][] rotate(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a[i].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = tmp;
        }
        return a;
    }
}
