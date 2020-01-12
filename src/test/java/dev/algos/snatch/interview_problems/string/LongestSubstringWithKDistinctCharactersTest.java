package dev.algos.snatch.interview_problems.string;

import dev.algos.snatch.interview_problems.sliding_window.LongestSubstringWithKDistinctCharacters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vladov 2019-12-21
 */
class LongestSubstringWithKDistinctCharactersTest {

    private LongestSubstringWithKDistinctCharacters instance;

    @BeforeEach
    void setUp() {
        instance = new LongestSubstringWithKDistinctCharacters();
    }

    @Test
    void findLengthHappyPath() {
        int result = instance.findLength("araaci", 2);
        assertThat(result, equalTo(4));
    }

    @Test
    void findLengthHappyPath2() {
        int result = instance.findLength("araaci", 1);
        assertThat(result, equalTo(2));
    }

    @Test
    void findLengthHappyPath3() {
        int result = instance.findLength("cbbebi", 3);
        assertThat(result, equalTo(5));
    }
}