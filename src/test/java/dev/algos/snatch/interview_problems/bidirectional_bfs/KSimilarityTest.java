package dev.algos.snatch.interview_problems.bidirectional_bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KSimilarityTest {

    @Test
    void test() {
        KSimilarity kSimilarity = new KSimilarity();
        assertEquals(4, kSimilarity.kSimilarity("aaabbbccc", "bbccaabac"));
    }
}
