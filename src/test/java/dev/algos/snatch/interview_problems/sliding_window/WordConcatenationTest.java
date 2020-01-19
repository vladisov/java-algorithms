package dev.algos.snatch.interview_problems.sliding_window;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * @author vladov 2019-12-26
 */
class WordConcatenationTest {

    private WordConcatenation instance;

    @BeforeEach
    void setUp() {
        instance = new WordConcatenation();
    }

    @Test
    void findWordConcatenationSuccess() {
        var result = instance.findWordConcatenation("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
        assertThat(result, hasSize(0));
    }

    @Test
    void findWordConcatenationSuccess1() {
        var result = instance.findWordConcatenation("barfoothefoobarman", new String[]{"foo", "bar"});
        assertThat(result, hasItems(0, 9));
    }

    @Test
    void findWordConcatenationSuccess2() {
        var result = instance.findWordConcatenation("catfoxcat", new String[]{"cat", "fox"});
        assertThat(result, hasItems(0, 3));
    }

    @Test
    void findWordConcatenationSuccess3() {
        var result = instance.findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"});
        assertThat(result, hasItems(3));
    }

    @Test
    void findWordConcatenationNullString() {
        var result = instance.findWordConcatenation(null, new String[]{"cat", "fox"});
        assertThat(result, hasSize(0));
    }
}