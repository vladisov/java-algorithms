package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSmallerNumberAfterSelfTest {

    @Test
    void test() {
        CountSmallerNumberAfterSelf instance = new CountSmallerNumberAfterSelf();
        assertEquals("[4, 2, 1, 1, 0]", instance.countSmaller(new int[]{7, 5, 2, 6, 1}).toString());
    }
}
