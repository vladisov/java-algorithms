package dev.algos.snatch.interview_problems.ds_design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RangeModuleTest {

    @Test
    void test() {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        assertTrue(rangeModule.queryRange(10, 14));
    }
}
