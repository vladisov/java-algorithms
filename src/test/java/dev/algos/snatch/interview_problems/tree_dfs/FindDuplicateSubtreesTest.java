package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.Test;

class FindDuplicateSubtreesTest {

    @Test
    void test() {
        TreeNode treeNode = TreeNode.parseFromLevelOrder("[1,2,3,4,null,2,4,null,null,4]");
        FindDuplicateSubtrees instance = new FindDuplicateSubtrees();
        instance.findDuplicateSubtrees(treeNode);
    }
}
