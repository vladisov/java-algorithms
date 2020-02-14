package dev.algos.snatch.interview_problems.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class FirstKMissingPositivesTest {

    private FirstKMissingPositives instance = new FirstKMissingPositives();

    @Test
    void findBaseCase() {
        assertThat(instance.findNumbers(new int[]{3, -1, 4, 5, 5}, 3), contains(1, 2, 6));
    }

    @Test
    void findGreaterThanNumberOfElements() {
        assertThat(instance.findNumbers(new int[]{1, 2, 3}, 3), contains(4, 5, 6));
    }

    @Test
    void findBaseCase2() {
        assertThat(instance.findNumbers(new int[]{2, 3, 4}, 3), contains(1, 5, 6));
    }
}
