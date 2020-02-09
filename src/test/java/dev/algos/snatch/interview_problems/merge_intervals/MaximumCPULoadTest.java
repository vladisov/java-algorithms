package dev.algos.snatch.interview_problems.merge_intervals;

import org.junit.jupiter.api.Test;

import static dev.algos.snatch.interview_problems.helpers.Job.buildList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MaximumCPULoadTest {

    private MaximumCPULoad instance = new MaximumCPULoad();

    @Test
    void textMaxCpuLoad() {
        assertThat(instance.findMaxCPULoad(buildList("[[1,4,3], [2,5,4], [7,9,6]]")), equalTo(7));
    }

    @Test
    void textMaxCpuLoad2() {
        assertThat(instance.findMaxCPULoad(buildList("[[6,7,10], [2,4,11], [8,12,15]]")), equalTo(15));
    }
}
