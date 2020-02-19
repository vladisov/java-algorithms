package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CountPathsForSumTest {

    private CountPathsForSum instance = new CountPathsForSum();

    @Test
    void testPaths() {
        TreeNode root = TreeNode.parseFromLevelOrder("[1,null,2,null,3,null,4,null,5]");
        assertThat(instance.pathSum(root, 3), equalTo(2));
    }
}
