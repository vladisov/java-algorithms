package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PathWithGivenSequenceTest {

    private PathWithGivenSequence instance = new PathWithGivenSequence();

    @Test
    void testFindPath() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        assertTrue(instance.findPath(root, new int[]{1, 1, 6}));
        assertFalse(instance.findPath(root, new int[]{1, 0, 7}));
    }
}
