package dev.algos.snatch.interview_problems.miscellaneous;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextClosestTimeTest {

    @Test
    void test() {
        NextClosestTime nextClosestTime = new NextClosestTime();
        assertEquals("19:39", nextClosestTime.nextClosestTime("19:34"));
    }
}
