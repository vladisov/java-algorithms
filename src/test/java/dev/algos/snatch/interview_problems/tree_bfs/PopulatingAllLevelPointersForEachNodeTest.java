package dev.algos.snatch.interview_problems.tree_bfs;

import dev.algos.snatch.interview_problems.helpers.TreeNodeNext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PopulatingAllLevelPointersForEachNodeTest {

    TreeNodeNext root;
    private PopulatingAllLevelPointersForEachNode instance;

    @BeforeEach
    void setUp() {
        instance = new PopulatingAllLevelPointersForEachNode();
        root = new TreeNodeNext(1);
        TreeNodeNext left = new TreeNodeNext(10);
        TreeNodeNext right = new TreeNodeNext(20);
        root.left = left;
        root.right = right;
        left.left = new TreeNodeNext(12);
        left.right = new TreeNodeNext(21);
        right.left = new TreeNodeNext(66);
        right.right = new TreeNodeNext(55);
    }

    @Test
    void testConnectAll() {
        TreeNodeNext newRoot = instance.connect(root);
        assertThat(newRoot.next.val, equalTo(10));
        assertThat(newRoot.left.next.val, equalTo(20));
        assertThat(newRoot.right.next.val, equalTo(12));
    }
}
