package dev.algos.snatch.interview_problems.array;

import dev.algos.snatch.interview_problems.sliding_window.CharacterReplacement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vladov 2019-12-24
 */
class CharacterReplacementTest {

    private CharacterReplacement instance;

    @BeforeEach
    void setUp() {
        instance = new CharacterReplacement();
    }

    @Test
    void findLengthSuccess() {
        int result = instance.findLength("aabccbb", 2);
        assertThat(result, equalTo(5));
    }


    @Test
    void findLengthSuccess2() {
        int result = instance.findLength("abbcb", 1);
        assertThat(result, equalTo(4));
    }

    @Test
    void findLengthSuccess3() {
        int result = instance.findLength("abccde", 1);
        assertThat(result, equalTo(3));
    }

    @Test
    void findLengthNull() {
        int result = instance.findLength(null, 1);
        assertThat(result, equalTo(0));
    }
}