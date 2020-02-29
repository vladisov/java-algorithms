package dev.algos.snatch.interview_problems.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SubsetsWithDuplicatesTest {

    SubsetsWithDuplicates instance = new SubsetsWithDuplicates();

    @Test
    void testSubsets() {
        List<List<Integer>> result = instance.subsetsWithDupEducative(new int[]{1, 2, 2});
        assertThat(result.toString(), equalTo("[[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]"));
    }
}
