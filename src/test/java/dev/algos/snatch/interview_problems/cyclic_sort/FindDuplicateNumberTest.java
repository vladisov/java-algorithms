package dev.algos.snatch.interview_problems.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

class FindDuplicateNumberTest {

    private FindDuplicateNumber instance = new FindDuplicateNumber();

    @Test
    void testFind() {
        assertThat(instance.findNumber(new int[]{1, 4, 4, 3, 2}), equalTo(4));
        assertThat(instance.findNumberFastSlow(new int[]{1, 4, 4, 3, 2}), equalTo(4));
        assertThat(instance.findNumberFastSlow(new int[]{1, 4, 5, 3, 2}), equalTo(-1));
    }

    @Test
    void testFindAll() {
        assertThat(instance.findAllNumbers(new int[]{5, 4, 7, 2, 3, 3, 5, 3}), contains(3, 5));
    }
}
