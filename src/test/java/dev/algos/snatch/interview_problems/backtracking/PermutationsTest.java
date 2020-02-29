package dev.algos.snatch.interview_problems.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PermutationsTest {

    private Permutations instance = new Permutations();

    @Test
    void testPermutations() {
        List<List<Integer>> result = instance.permute(new int[]{1, 2, 3});
        assertThat(result.toString(), equalTo("[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]"));
    }
}
