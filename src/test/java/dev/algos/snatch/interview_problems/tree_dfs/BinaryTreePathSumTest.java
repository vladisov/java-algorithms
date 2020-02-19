package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreePathSumTest {

    BinaryTreePathSum instance = new BinaryTreePathSum();

    @Test
    void testSingleElementPath() {
        TreeNode root = TreeNode.parseFromLevelOrder("[1]");
        assertTrue(instance.hasPath(root, 1));
        assertTrue(instance.hasPathIterative(root, 1));
    }

    @Test
    void testHasPathHappyCase() {
        TreeNode root = TreeNode.parseFromLevelOrder("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        assertTrue(instance.hasPath(root, 22));
        assertTrue(instance.hasPathIterative(root, 22));
    }

    @Test
    void testHasPathZeroCase() {
        TreeNode root = TreeNode.parseFromLevelOrder("[1,0]");
        assertFalse(instance.hasPath(root, 0));
        assertFalse(instance.hasPathIterative(root, 0));
        assertTrue(instance.hasPath(root, 1));
        assertTrue(instance.hasPathIterative(root, 1));
    }

    @Test
    void testHasPathTwoElements() {
        TreeNode root = TreeNode.parseFromLevelOrder("[1,2]");
        assertFalse(instance.hasPath(root, 1));
        assertTrue(instance.hasPath(root, 3));
        assertTrue(instance.hasPathIterative(root, 3));
    }
}
