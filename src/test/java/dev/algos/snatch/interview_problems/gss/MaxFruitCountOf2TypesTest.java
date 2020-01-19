package dev.algos.snatch.interview_problems.gss;

import dev.algos.snatch.interview_problems.sliding_window.MaxFruitCountOf2Types;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vladov 2019-12-24
 */
class MaxFruitCountOf2TypesTest {

    private MaxFruitCountOf2Types instance;

    @BeforeEach
    void setUp() {
        instance = new MaxFruitCountOf2Types();
    }

    @Test
    void maxFruitCountHappyPath() {
        int result = instance.findLength(new char[]{'A', 'B', 'C', 'A', 'C'});
        assertThat(result, equalTo(3));
    }


    @Test
    void maxFruitCount2() {
        int result = instance.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'});
        assertThat(result, equalTo(5));
    }

    @Test
    void maxFruitCountEmpty() {
        int result = instance.findLength(new char[]{});
        assertThat(result, equalTo(0));
    }
}
