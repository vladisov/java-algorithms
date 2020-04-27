package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class RecoverBinarySearchTreeTest {

    @Test
    void test() {
        RecoverBinarySearchTree instance = new RecoverBinarySearchTree();

        TreeNode tree = TreeNode.parseFromLevelOrder("[1,3,null,null,2]");
        instance.recoverTree(tree);
        assertThat(tree.toString(), equalTo("1,2,3"));
    }
}
