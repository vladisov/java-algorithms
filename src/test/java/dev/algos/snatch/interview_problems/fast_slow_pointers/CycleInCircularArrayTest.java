package dev.algos.snatch.interview_problems.fast_slow_pointers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CycleInCircularArrayTest {

    private CycleInCircularArray instance = new CycleInCircularArray();


    @Test
    void testLoopExists() {
        boolean result = instance.loopExists(new int[]{1, 2, -1, 2, 2});
        assertThat(result, equalTo(true));
    }

    @Test
    void testLoopExists2() {
        boolean result = instance.loopExists(new int[]{2, 2, -1, 2});
        assertThat(result, equalTo(true));
    }


    @Test
    void testLoopDoesNotExist() {
        boolean result = instance.loopExists(new int[]{2, 1, -1, -2});
        assertThat(result, equalTo(false));
    }

    @Test
    void testLoopDoesNotExist2() {
//        boolean result = instance.loopExists(new int[]{-1, 2});
        boolean result = instance.circularArrayLoop(new int[]{-1, 2});
        assertThat(result, equalTo(false));
    }
}
