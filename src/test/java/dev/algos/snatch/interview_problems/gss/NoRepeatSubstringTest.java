package dev.algos.snatch.interview_problems.gss;

import dev.algos.snatch.interview_problems.sliding_window.NoRepeatSubstring;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vladov 2019-12-24
 */
class NoRepeatSubstringTest {

    private NoRepeatSubstring instance;

    @BeforeEach
    void setUp() {
        instance = new NoRepeatSubstring();
    }

    @Test
    void noRepeatHappyPath() {
        int result = instance.findLength("aabccbb");
        assertThat(result, equalTo(3));
    }


    @Test
    void noRepeat2() {
        int result = instance.findLength("abbbb");
        assertThat(result, equalTo(2));
    }

    @Test
    void noRepeatEmpty() {
        int result = instance.findLength("");
        assertThat(result, equalTo(0));
    }

    @Test
    void noRepeatNull() {
        int result = instance.findLength(null);
        assertThat(result, equalTo(0));
    }
}
