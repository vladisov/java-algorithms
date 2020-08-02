package dev.algos.snatch.interview_problems.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextPowerOfTwoTest {

    @Test
    void test() {
        NextPowerOfTwo npt = new NextPowerOfTwo();
        assertEquals(8, npt.nextPowerOfTwo(8));
        assertEquals(16, npt.nextPowerOfTwo(9));
    }
}
