package dev.algos.snatch.interview_problems.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FindCorruptPairTest {

    private FindCorruptPair instance = new FindCorruptPair();

    @Test
    void findCorruptPair() {
        int[] result = instance.findNumbers(new int[]{3, 1, 2, 3, 6, 4});
        assertThat(result, equalTo(new int[]{3, 5}));
    }

    @Test
    void findCorruptPair2() {
        int[] result = instance.findNumbers(new int[]{3, 1, 2, 5, 2});
        assertThat(result, equalTo(new int[]{2, 4}));
    }
}
