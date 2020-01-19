package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 2020-01-07
 */
class BackspaceCompareTest {

    private BackspaceCompare instance;

    @BeforeEach
    void setUp() {
        instance = new BackspaceCompare();
    }

    @Test
    void testBackspaceCompareHappyPath() {
        var result = instance.compare("xy#z", "xzz#");
        assertThat(result, equalTo(true));
    }

    @Test
    void testBackspaceCompareDoubleSpaces() {
        var result = instance.compare("xp#", "xyz##");
        assertThat(result, equalTo(true));
    }

    @Test
    void testBackspaceCompareInMiddle() {
        var result = instance.compare("xywrrmp", "xywrrmu#p");
        assertThat(result, equalTo(true));
    }

    @Test
    void testBackspaceCompareHappyPath2() {
        var result = instance.compare("xy#z", "xyz#");
        assertThat(result, equalTo(false));
    }

    @Test
    void testBackspaceCompareEmptyString() {
        var result = instance.compare("ab##", "c#d#");
        assertThat(result, equalTo(true));
    }

    @Test
    void testBackspaceCompareSeparatedSpaces() {
        var result = instance.compare("bxj##tw", "bxo#j##tw");
        assertThat(result, equalTo(true));
    }

    @Test
    void testBackspaceCompareMoreSpaces() {
        var result = instance.compare("bxj##tw", "bxj###tw");
        assertThat(result, equalTo(false));
    }

    @Test
    void testBackspaceCompareFirstSpace() {
        var result = instance.compare("a##c", "#a#c");
        assertThat(result, equalTo(true));
    }

}