package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 22/02/2020
 */
class PathToMaxSumTest {

    private PathToMaxSum instance = new PathToMaxSum();

    @Test
    void testPathMaxSum() {
        TreeNode node = TreeNode.parseFromLevelOrder("[-10,9,20,null,null,15,7]");
        assertThat(instance.maxPathSum(node), equalTo(42));
    }
}
