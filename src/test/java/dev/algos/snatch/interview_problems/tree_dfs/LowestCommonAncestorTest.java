package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class LowestCommonAncestorTest {

    private LowestCommonAncestor instance = new LowestCommonAncestor();

    @Test
    void testLowestAncestor() {
        TreeNode root = TreeNode.parseFromLevelOrder("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode result = instance.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        assertThat(result.val, equalTo(2));
    }

}
