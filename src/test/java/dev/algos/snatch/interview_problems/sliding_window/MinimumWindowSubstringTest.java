package dev.algos.snatch.interview_problems.sliding_window;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


class MinimumWindowSubstringTest {

    private MinimumWindowSubstring instance;

    @BeforeEach
    void setUp() {
        instance = new MinimumWindowSubstring();
    }

    @Test
    void findSubstringSuccess() {
        var result = instance.findSubstring("aabdec", "abc");
        assertThat(result, equalTo("abdec"));
    }

    @Test
    void findSubstringSuccess1() {
        var result = instance.findSubstring("abdabca", "abc");
        assertThat(result, equalTo("abc"));
    }

    @Test
    void findSubstringEmpty() {
        var result = instance.findSubstring("adcad", "abc");
        assertThat(result, equalTo(""));
    }
}