package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.Test;

import java.util.List;

class FindDuplicatesInThreeArraysTest {

    @Test
    void testBaseCase() {
        FindDuplicatesInThreeArrays instance = new FindDuplicatesInThreeArrays();

        final List<Integer> duplicates = instance.findDuplicates(new int[]{1, 2, 3, 4, 5},
                new int[]{2, 5, 6},
                new int[]{5, 2, 11, 12});
    }
}
