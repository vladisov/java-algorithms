package dev.algos.snatch.interview_problems.top_k;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class RearrangeKDistanceApartTest {

    @Test
    void test() {
        RearrangeKDistanceApart distanceApart = new RearrangeKDistanceApart();
        assertThat(distanceApart.rearrangeString("aaaaaaaadbbdcdcc", 2), equalTo("adacadacabacabda"));
    }
}
