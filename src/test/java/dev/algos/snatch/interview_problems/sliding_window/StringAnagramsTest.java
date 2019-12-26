package dev.algos.snatch.interview_problems.sliding_window;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vladov 2019-12-25
 */
class StringAnagramsTest {

    private StringAnagrams instance;

    @BeforeEach
    void setUp() {
        instance = new StringAnagrams();
    }

    @Test
    void findAnagrams() {
        var result = instance.findStringAnagrams("ppqp", "qp");
        assertThat(result, hasItems(1, 2));
    }

    @Test
    void findAnagrams1() {
        var result = instance.findStringAnagrams("abbcabc", "abc");
        assertThat(result, hasItems(2, 3, 4));
    }
}