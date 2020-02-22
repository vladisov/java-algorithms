package dev.algos.snatch.interview_problems.helpers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

class TreeNodeTest {

    @Test
    void testParseString() {
        TreeNode root = TreeNode.parseFromLevelOrder("[3,9,20,null,null,15,7]");
        assertThat(root.toStringLevelOrder(), equalTo("[3,9,20,null,null,15,7]"));
    }

    @Test
    void testParseEmptyListString() {
        TreeNode root = TreeNode.parseFromLevelOrder("[]");
        assertThat(root, nullValue());
    }
}
