package dev.algos.snatch.interview_problems.matrix;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class RotateImageTest {

    private RotateImage instance = new RotateImage();

    @Test
    void testRotate() {
        int[][] result = instance.rotateImage(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        assertThat(result, equalTo(new int[][]{
                        {7, 4, 1},
                        {8, 5, 2},
                        {9, 6, 3}
                }
        ));
    }

    @Test
    void testRotate4() {
        int[][] result = instance.rotateImage(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });
        assertThat(result, equalTo(new int[][]{
                        {13, 9, 5, 1},
                        {14, 10, 6, 2},
                        {15, 11, 7, 3},
                        {16, 12, 8, 4}
                }
        ));
    }
}
