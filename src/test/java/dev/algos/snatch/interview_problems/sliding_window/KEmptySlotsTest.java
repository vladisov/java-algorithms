package dev.algos.snatch.interview_problems.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KEmptySlotsTest {

    @Test
    void test() {
        KEmptySlots kEmptySlots = new KEmptySlots();
        assertEquals(2, kEmptySlots.kEmptySlots(new int[]{1, 3, 2}, 1));
    }
}
