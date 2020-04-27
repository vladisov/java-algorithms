package dev.algos.snatch.interview_problems.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class WordLadder_IITest {

    @Test
    void test() {
        WordLadder_II wordLadder = new WordLadder_II();
        assertThat(wordLadder.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")).toString(),
                equalTo("[[hit, hot, dot, dog, cog], [hit, hot, lot, log, cog]]"));
        assertThat(wordLadder.findLadders("hot", "dog", List.of("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot")).toString(),
                equalTo("[[hot, dot, dog], [hot, hog, dog]]"));
    }
}
