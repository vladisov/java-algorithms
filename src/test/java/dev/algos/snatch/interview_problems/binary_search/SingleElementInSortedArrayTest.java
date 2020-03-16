package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleElementInSortedArrayTest {

    @Test
    void test() {
        SingleElementInSortedArray instance = new SingleElementInSortedArray();
        assertEquals(2, instance.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        assertEquals(10, instance.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        assertEquals(11, instance.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 10, 11}));
        assertEquals(2, instance.singleNonDuplicate(new int[]{2, 3, 3, 7, 7, 10, 10}));
    }

}
