package dev.algos.snatch.interview_problems.gss.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAnagramsTest {

    private StringAnagrams solution = new StringAnagrams();


    @Test
    void anagrams() {
        assertThat(solution.findStringAnagrams("ppqp", "pq"))
                .hasSize(2)
                .contains(1, 2);
        assertThat(solution.findStringAnagrams("abbcabc", "abc"))
                .hasSize(3)
                .contains(2, 3, 4);
    }
}
