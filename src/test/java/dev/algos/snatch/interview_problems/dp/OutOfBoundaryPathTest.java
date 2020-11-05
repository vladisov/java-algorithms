package dev.algos.snatch.interview_problems.dp;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class OutOfBoundaryPathTest {

    @Test
    void test() {
        OutOfBoundaryPath instance = new OutOfBoundaryPath();
        assertThat(instance.findPaths(1, 3, 3, 0, 1), equalTo(12));
        assertThat(instance.findPathsBottomUp(2, 2, 2, 0, 0), equalTo(6));
        assertThat(instance.findPathsBottomUpOptimized(2, 2, 2, 0, 0), equalTo(6));
        assertThat(instance.findPathsBottomUp(1, 3, 3, 0, 1), equalTo(12));
        assertThat(instance.findPathsBottomUpOptimized(1, 3, 3, 0, 1), equalTo(12));
    }
}
