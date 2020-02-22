package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SumOfPathNumbersTest {

    private SumOfPathNumbers instance = new SumOfPathNumbers();

    @Test
    void testSumOfPathNumbers() {
        assertThat(instance.sumNumbers(TreeNode.parseFromLevelOrder("[4,9,0,5,1]")), equalTo(1026));
    }
}