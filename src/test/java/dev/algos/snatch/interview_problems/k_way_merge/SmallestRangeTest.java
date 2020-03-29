package dev.algos.snatch.interview_problems.k_way_merge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SmallestRangeTest {

    @Test
    void test() {
        SmallestRange instance = new SmallestRange();
        var input = List.of(
                List.of(4, 10, 15, 24, 26),
                List.of(0, 9, 12, 20),
                List.of(5, 18, 22, 30)
        );
        assertThat(instance.findSmallestRange(input), equalTo(new int[]{20, 24}));
    }
}

