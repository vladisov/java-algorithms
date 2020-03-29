package dev.algos.snatch.interview_problems.top_k;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class TaskSchedulerTest {

    @Test
    void test() {
        TaskScheduler taskScheduler = new TaskScheduler();

        assertThat(taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2), equalTo(8));
    }
}
