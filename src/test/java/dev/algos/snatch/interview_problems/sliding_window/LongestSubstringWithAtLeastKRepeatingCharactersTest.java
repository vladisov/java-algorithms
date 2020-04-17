package dev.algos.snatch.interview_problems.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithAtLeastKRepeatingCharactersTest {

    @Test
    void test() {
        LongestSubstringWithAtLeastKRepeatingCharacters lswk = new LongestSubstringWithAtLeastKRepeatingCharacters();
        assertEquals(3, lswk.longestSubstring("aaabb", 3));
        assertEquals(5, lswk.longestSubstring("ababbc", 2));
    }
}
