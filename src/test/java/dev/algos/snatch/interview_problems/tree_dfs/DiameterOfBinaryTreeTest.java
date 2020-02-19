package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DiameterOfBinaryTreeTest {


    private DiameterOfBinaryTree instance = new DiameterOfBinaryTree();

    @Test
    void findDiameter() {
        TreeNode root = TreeNode.parseFromLevelOrder("[1,2,3,4,5,null,null,6,null,9,null,null,7,null,4]");
        assertThat(instance.findDiameter(root), equalTo(7));
    }
}
