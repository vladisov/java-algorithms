package dev.algos.snatch.interview_problems.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SubsetsTest {

    private Subsets instance = new Subsets();

    @Test
    void testSubsets() {
        List<List<Integer>> result = instance.subsets(new int[]{1, 2, 3});
        assertThat(result.toString(), equalTo("[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]"));
    }
}
