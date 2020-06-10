package dev.algos.snatch.interview_problems.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicateLettersTest {

    @Test
    void test() {
        RemoveDuplicateLetters instance = new RemoveDuplicateLetters();
        assertEquals("bca", instance.removeDuplicateLetters("bcab"));
        assertEquals("abc", instance.removeDuplicateLetters("bcabc"));
        assertEquals("acdb", instance.removeDuplicateLetters("cbacdcbc"));
    }
}
