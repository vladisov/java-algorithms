package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MinimumDeletionsToMakeSortedSequenceTest {

    @Test
    void test() {
        MinimumDeletionsToMakeSortedSequence mdel = new MinimumDeletionsToMakeSortedSequence();

        assertThat(mdel.minDeletions(new int[]{4, 2, 3, 6, 10, 1, 12}), equalTo(2));
        assertThat(mdel.minDeletions(new int[]{-4, 10, 3, 7, 15}), equalTo(1));
        assertThat(mdel.minDeletions(new int[]{3, 2, 1, 0}), equalTo(3));
        assertThat(mdel.minDeletionsBU(new int[]{4, 2, 3, 6, 10, 1, 12}), equalTo(2));
    }
}
