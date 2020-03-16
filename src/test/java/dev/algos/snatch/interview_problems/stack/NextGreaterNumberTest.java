package dev.algos.snatch.interview_problems.stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextGreaterNumberTest {

    @Test
    void test() {
        NextGreaterNumber instance = new NextGreaterNumber();
        int[] res = instance.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        assertEquals("[-1, 3, -1]", Arrays.toString(res));
    }
}
