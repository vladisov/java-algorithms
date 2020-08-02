package dev.algos.snatch.interview_problems.ds_design;

import org.junit.jupiter.api.Test;

class DinnerPlatesTest {

    @Test
    void test() {
        DinnerPlates dp = new DinnerPlates(1);
        dp.push(1);
        dp.push(2);
        dp.popAtStack(1);
        dp.pop();
        dp.push(1);
        dp.push(2);
        dp.pop();
        dp.pop();
    }
}
