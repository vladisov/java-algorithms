package dev.algos.snatch.interview_problems.top_k;

import org.junit.jupiter.api.Test;

class TaskSchedulerTest {

    @Test
    void test() {
        TaskScheduler taskScheduler = new TaskScheduler();

        taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }
}
