package dev.algos.snatch.interview_problems.two_heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageOfKTest {

    @Test
    void test() {
        AverageOfK avg = new AverageOfK(100);
        for (int i = 1; i <= 100; i++) {
            avg.add(i);
        }
        assertEquals(10, avg.getAvarage());
    }

}
