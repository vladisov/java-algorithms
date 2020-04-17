package dev.algos.snatch.interview_problems.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecodeWaysTest {

    @Test
    void test() {
        DecodeWays dw = new DecodeWays();

        assertEquals(3, dw.numDecodings("226"));
        assertEquals(2, dw.numDecodings("12"));
        assertEquals(3, dw.numDecodingsBU("226"));
        assertEquals(2, dw.numDecodingsBU("12"));
    }
}
