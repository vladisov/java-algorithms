package dev.algos.snatch.interview_problems.matrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MatrixRotationsTest {

    private MatrixRotations instance = new MatrixRotations();


    @Test
    void test() {

        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 2, 3, 4));
        input.add(Arrays.asList(5, 6, 7, 8));
        input.add(Arrays.asList(9, 10, 11, 12));
        input.add(Arrays.asList(13, 14, 15, 16));

        instance.matrixRotation(input, 1);

        /*
        [2, 3, 4, 8],
        [1, 7, 11, 12],
        [5, 6, 10, 16],
        [9, 13, 14, 15]
         */
        assertThat(input.toString(), equalTo("[[2, 3, 4, 8], [1, 7, 11, 12], [5, 6, 10, 16], [9, 13, 14, 15]]"));
    }
}
