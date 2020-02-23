package dev.algos.snatch.interview_problems.two_heaps;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 23/02/2020
 */
class IPOTest {

    private IPO instance = new IPO();

    @Test
    void testBaseCase() {
//        k=2, W=0, Profits=[1,2,3], Capital=[0,1,1]
        int result = instance.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        assertThat(result, equalTo(4));
    }

    @Test
    void testBaseCase2() {
//      Project Capitals=[0,1,2,3], Project Profits=[1,2,3,5], Initial Capital=0, Number of Projects=3
        int result = instance.findMaximizedCapital(3, 0, new int[]{1, 2, 3, 5}, new int[]{0, 1, 2, 3});
        assertThat(result, equalTo(8));
    }

    @Test
    void testBaseCase3() {
        int result = instance.findMaximizedCapital(1, 0, new int[]{1, 2, 3}, new int[]{1, 1, 2});
        assertThat(result, equalTo(0));
    }
}