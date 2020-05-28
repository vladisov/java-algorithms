package dev.algos.snatch.interview_problems.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CyclicSortTest {

    private CyclicSort instance = new CyclicSort();

    @Test
    void testSort1() {
        var arr = new int[]{3, 1, 5, 4, 2};
        instance.sort(arr);
        assertThat(arr, equalTo(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void testSort2() {
        var arr = new int[]{1, 5, 6, 4, 3, 2};
        instance.sort(arr);
        assertThat(arr, equalTo(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
