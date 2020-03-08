package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FindKClosestElementsTest {

    private FindKClosestElements instance = new FindKClosestElements();

    @Test
    void test() {
        List<Integer> elements = instance.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        assertThat(elements, equalTo(List.of(1, 2, 3, 4)));
    }
}
