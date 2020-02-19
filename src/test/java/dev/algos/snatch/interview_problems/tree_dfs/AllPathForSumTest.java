package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class AllPathForSumTest {

    AllPathForSum instance = new AllPathForSum();

    @Test
    void testHasPathHappyCase() {
        TreeNode root = TreeNode.parseFromLevelOrder("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        assertThat(instance.pathSum(root, 22).toString(), equalTo(
                "[[5, 4, 11, 2], [5, 8, 4, 5]]"));
        assertThat(instance.pathSumRec(root, 22).toString(), equalTo(
                "[[5, 4, 11, 2], [5, 8, 4, 5]]"));
    }
}

