package dev.algos.snatch.interview_problems.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfStringsContainingAllThreeCharactersTest {

    @Test
    void test() {
        NumberOfStringsContainingAllThreeCharacters instance = new NumberOfStringsContainingAllThreeCharacters();
        assertEquals(10, instance.numberOfSubstrings("abcabc"));
    }
}
