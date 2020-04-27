package dev.algos.snatch.data_structures.tree.algorithms;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class InorderTraversalTest {

    @Test
    void test() {
        InorderTraversal inorder = new InorderTraversal();

        assertThat(inorder.inorderTraversalIterative(TreeNode.parseFromLevelOrder("[1,null,2,3]")).toString(),
                equalTo("[1, 3, 2]"));
        assertThat(inorder.inorderTraversalRecursive(TreeNode.parseFromLevelOrder("[1,null,2,3]")).toString(),
                equalTo("[1, 3, 2]"));
        assertThat(inorder.inorderTraversalMorris(TreeNode.parseFromLevelOrder("[1,null,2,3]")).toString(),
                equalTo("[1, 3, 2]"));
    }
}
