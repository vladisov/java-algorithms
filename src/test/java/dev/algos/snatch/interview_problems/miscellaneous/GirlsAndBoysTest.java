package dev.algos.snatch.interview_problems.miscellaneous;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GirlsAndBoysTest {

    @Test
    void test() {
        GirlsAndBoys girlsAndBoys = new GirlsAndBoys();

        assertEquals(3, girlsAndBoys.girlsBoys(5, 1));
        assertEquals(3, girlsAndBoys.girlsBoys(10, 3));
        assertEquals(2, girlsAndBoys.girlsBoys(8, 3));
    }
}
