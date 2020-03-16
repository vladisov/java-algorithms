package dev.algos.snatch.interview_problems.xor;

import org.junit.jupiter.api.Test;

class SingleNumberTest {

    @Test
    void test() {
        SingleNumber sn = new SingleNumber();
        sn.findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3});
    }

}
