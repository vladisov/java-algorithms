package dev.algos.snatch.interview_problems.sliding_window;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vladov 2019-12-25
 */
class StringPermutationTest {

    private StringPermutation instance;

    @BeforeEach
    void setUp() {
        instance = new StringPermutation();
    }

    @Test
    void findPermutationEmptyStrings() {
        boolean result = instance.findPermutation("", "");
        assertThat(result, equalTo(false));
    }

    @Test
    void findPermutationSuccess() {
        boolean result = instance.findPermutation("oidbcaf", "abc");
        assertThat(result, equalTo(true));
    }

    @Test
    void findPermutationSuccess1() {
        boolean result = instance.findPermutation("odicf", "dc");
        assertThat(result, equalTo(false));
    }
}