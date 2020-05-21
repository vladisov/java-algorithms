package dev.algos.snatch.interview_problems.miscellaneous;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecodeStringTest {

    @Test
    void test() {
        DecodeString decodeString = new DecodeString();

        assertEquals("", decodeString.decodeString("3[a2[c]]"));
    }
}
