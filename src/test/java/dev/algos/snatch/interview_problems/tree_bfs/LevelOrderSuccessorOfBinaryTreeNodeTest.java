package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

class LevelOrderSuccessorOfBinaryTreeNodeTest {

    private LevelOrderSuccessorOfBinaryTreeNode instance = new LevelOrderSuccessorOfBinaryTreeNode();

    @Test
    void testFindSuccessor() {
        TreeNode root = TreeNode.parseFromLevelOrder("[3,9,20,null,null,15,7]");
        assertThat(instance.findSuccessor(root, 9), equalTo(20));
    }

    @Test
    void testFindSuccessorEmpty() {
        TreeNode root = TreeNode.parseFromLevelOrder("[3,9,20,null,null,15,7]");
        assertThat(instance.findSuccessor(root, 7), nullValue());
    }
}
