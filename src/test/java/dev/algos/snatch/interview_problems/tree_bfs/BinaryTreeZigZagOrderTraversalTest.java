package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

class BinaryTreeZigZagOrderTraversalTest {

    @Test
    void testZigZag() {
        TreeNode root = TreeNode.parseFromLevelOrder("[3,9,20,null,null,15,7]");
        BinaryTreeZigZagOrderTraversal instance = new BinaryTreeZigZagOrderTraversal();
        List<List<Integer>> result = instance.zigzagLevelOrder(root);
        assertThat(result, hasSize(3));
        assertThat(result.get(0), contains(3));
        assertThat(result.get(1), contains(20, 9));
        assertThat(result.get(2), contains(15, 7));
    }
}
