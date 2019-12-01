package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * @author vladov 2019-12-01
 */
class ExampleProblemTest {

    private ExampleProblem instance;

    @BeforeEach
    void setUp() {
        instance = new ExampleProblem();
    }

    @Test
    void testElementExists() {
        int[] arr = new int[]{1, 2, 3};
        int result = instance.exampleProblem(arr, 1);
        assertThat(result, equalTo(0));
    }
}