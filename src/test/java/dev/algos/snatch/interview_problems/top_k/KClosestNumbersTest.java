package dev.algos.snatch.interview_problems.top_k;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class KClosestNumbersTest {

    @Test
    void test() {
        KClosestNumbers instance = new KClosestNumbers();

        assertThat(instance.findClosestElements(new int[]{5, 6, 7, 8, 9}, 3, 7), containsInAnyOrder(6, 7, 8));
        assertThat(instance.findClosestElements(new int[]{5, 6, 7, 8, 9}, 3, 3), containsInAnyOrder(5, 6, 7));
        assertThat(instance.findClosestElements(new int[]{4, 6, 7, 8, 9}, 3, 5), containsInAnyOrder(4, 6, 7));
    }
}
