package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

class BinaryTreeRightSideViewTest {

    @Test
    void testLevelOrder() {
        TreeNode root = TreeNode.parseFromLevelOrder("[1,2,3,null,5,null,4]");
        BinaryTreeRightSideView instance = new BinaryTreeRightSideView();
        List<Integer> result = instance.rightSideView(root);
        assertThat(result, hasSize(3));
        assertThat(result, contains(1, 3, 4));
    }
}