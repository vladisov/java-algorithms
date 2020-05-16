package dev.algos.snatch.interview_problems.trie;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PalindromePairsTest {

    @Test
    void test() {
        PalindromePairs pairs = new PalindromePairs();
        List<List<Integer>> result = pairs.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});

        assertThat(result.toString(), equalTo("[]"));
    }
}
