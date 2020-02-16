package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class TreeBoundaryTest {

    private TreeBoundary instance = new TreeBoundary();

    @Test
    void testFindSuccessor() {
        TreeNode root = TreeNode.parseFromLevelOrder("[1,2,3,null,5,null,4]");
        assertThat(instance.findBoundary(root), contains(1, 2, 5, 4, 3));
    }
}
