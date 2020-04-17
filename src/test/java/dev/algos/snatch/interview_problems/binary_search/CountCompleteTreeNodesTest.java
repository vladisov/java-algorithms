package dev.algos.snatch.interview_problems.binary_search;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


class CountCompleteTreeNodesTest {


    @Test
    void test() {
        CountCompleteTreeNodes instance = new CountCompleteTreeNodes();
        TreeNode root = TreeNode.parseFromLevelOrder("[1,2,3,4,5,6]");
        assertThat(instance.countNodes(root), equalTo(6));
    }
}
