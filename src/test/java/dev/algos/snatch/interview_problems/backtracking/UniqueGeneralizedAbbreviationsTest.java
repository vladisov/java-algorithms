package dev.algos.snatch.interview_problems.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class UniqueGeneralizedAbbreviationsTest {

    private UniqueGeneralizedAbbreviations abbreviations = new UniqueGeneralizedAbbreviations();

    @Test
    void testBackTrack() {
        List<String> bat = abbreviations.generateAbbreviations("BAT");
        assertThat(bat.toString(), equalTo("[3, 2T, 1A1, 1AT, B2, B1T, BA1, BAT]"));
    }

}
