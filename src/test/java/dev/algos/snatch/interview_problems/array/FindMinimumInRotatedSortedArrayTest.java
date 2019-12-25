package dev.algos.snatch.interview_problems.array;

import dev.algos.snatch.interview_problems.binary_search.FindMinimumInRotatedSortedArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vladov 2019-12-09
 */
class FindMinimumInRotatedSortedArrayTest {

    private FindMinimumInRotatedSortedArray instance;

    @BeforeEach
    void setUp() {
        instance = new FindMinimumInRotatedSortedArray();
    }

    @Test
    void findMinRight() {
        int min = instance.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        assertThat(min, equalTo(0));
    }

    @Test
    void findMinLef() {
        int min = instance.findMin(new int[]{7, 0, 1, 2, 3, 4, 5});
        assertThat(min, equalTo(0));
    }


    @Test
    void findMinSorted() {
        int min = instance.findMin(new int[]{0, 1, 2, 3, 4, 5, 6});
        assertThat(min, equalTo(0));
    }

    @Test
    void findMinMiddle() {
        int min = instance.findMin(new int[]{4, 5, 6, 0, 1, 2, 3});
        assertThat(min, equalTo(0));
    }
}