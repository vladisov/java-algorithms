package dev.algos.snatch.interview_problems.tree_bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class QuadTreeTest {

    @Test
    void test() {
        QuadTree quadTree = new QuadTree();
        QuadTree.Node construct = quadTree.construct(new int[][]{
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        });
        assertNotNull(construct);
    }
}
