package dev.algos.snatch.interview_problems.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FindMissingNumberTest {

    private FindMissingNumber instance = new FindMissingNumber();

    @Test
    void findNumber() {
        int number = instance.findMissingNumber(new int[] {8, 3, 5, 2, 4, 6, 0, 1});
        assertThat(number, equalTo(7));
    }

    @Test
    void findNumberXor() {
        int number = instance.findMissingNumberXor(new int[]{3, 0, 1});
        assertThat(number, equalTo(2));
    }
}
