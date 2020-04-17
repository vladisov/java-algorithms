package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class BinaryTreePostOrderTraversalTest {


    @Test
    void test() {
        BinaryTreePostOrderTraversal instance = new BinaryTreePostOrderTraversal();
        assertThat(instance.postOrderTraversal(TreeNode.parseFromLevelOrder("[1,null,2,3]")).toString(), equalTo("[3, 2, 1]"));
        assertThat(instance.postOrderTraversal2(TreeNode.parseFromLevelOrder("[1,null,2,3]")).toString(), equalTo("[3, 2, 1]"));
    }
}
