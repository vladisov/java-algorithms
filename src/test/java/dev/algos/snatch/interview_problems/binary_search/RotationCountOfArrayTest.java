package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class RotationCountOfArrayTest {

    @Test
    void test() {
        RotationCountOfArray instance = new RotationCountOfArray();
        assertThat(instance.countRotations(new int[]{10, 15, 1, 3, 8}), equalTo(2));
        assertThat(instance.countRotations(new int[]{4, 5, 7, 9, 10, -1, 2}), equalTo(5));
        assertThat(instance.countRotations(new int[]{1, 3, 8, 10}), equalTo(0));
    }
}
