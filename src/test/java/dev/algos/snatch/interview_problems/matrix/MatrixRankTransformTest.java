package dev.algos.snatch.interview_problems.matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MatrixRankTransformTest {

    @Test
    void test() {
        MatrixRankTransform mrt = new MatrixRankTransform();
//        int[][] res = mrt.matrixRankTransform(new int[][]{{1, 2}, {3, 4}});
//        int[][] res1 = mrt.matrixRankTransform(new int[][]{{7, 7}, {7, 7}});
        int[][] res2 = mrt.matrixRankTransform(new int[][]{
                {-2, -35, -32, -5, -30, 33, -12},
                {7, 2, -43, 4, -49, 14, 17},
                {4, 23, -6, -15, -24, -17, 6},
                {-47, 20, 39, -26, 9, -44, 39},
                {-50, -47, 44, 43, -22, 33, -36},
                {-13, 34, 49, 24, 23, -2, -35},
                {-40, 43, -22, -19, -4, 23, -18}
        });
        System.out.println(Arrays.deepToString(res2));
        /*
        [
        [10, 3, 4, 9, 5, 15, 8],
        [12, 4, 2, 10, 1, 13, 14],
        [11, 13, 9, 8, 6, 7, 12],
        [2, 10, 11, 4, 9, 3, 15],
        [1, 2, 17, 16, 7, 15, 3],
        [5, 14, 18, 11, 10, 8, 4],
        [3, 15, 5, 6, 8, 14, 7]]

        [[13, 4, 5, 12, 6, 18, 11],
        [15, 5, 2, 14, 1, 16, 17],
        [14, 17, 11, 10, 7, 8, 15],
        [2, 13, 18, 4, 12, 3, 18],
        [1, 2, 21, 20, 8, 18, 3],
        [5, 19, 22, 18, 17, 13, 4],
        [3, 20, 8, 9, 11, 17, 10]]

        [[10, 3, 4, 9, 5, 15, 8],
        [12, 4, 2, 10, 1, 13, 14],
        [11, 13, 9, 8, 6, 7, 12],
        [2, 10, 15, 4, 9, 3, 15],
        [1, 2, 17, 16, 7, 15, 3], [5, 14, 18, 11, 10, 8, 4], [3, 15, 5, 6, 8, 14, 7]]


         */
    }
}
