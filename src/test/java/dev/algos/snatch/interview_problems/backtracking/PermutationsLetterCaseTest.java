package dev.algos.snatch.interview_problems.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PermutationsLetterCaseTest {

    private PermutationsLetterCase instance = new PermutationsLetterCase();

    @Test
    void testPermutations() {
        List<String> result = instance.letterCasePermutation("a1b2");
        assertThat(result.toString(), equalTo("[a1b2, a1B2, A1b2, A1B2]"));
    }

}
