package dev.algos.snatch.data_structures.union_find;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class UnionFindTest {

    @Test
    void testBaseCase() {
        UnionFind uf = new UnionFind(10);
        uf.union(3, 4);
        assertThat(uf.toString(), equalTo("[0, 1, 2, 4, 4, 5, 6, 7, 8, 9]"));
        uf.union(6, 4);
        assertThat(uf.toString(), equalTo("[0, 1, 2, 4, 4, 5, 4, 7, 8, 9]"));
        uf.union(3, 6);
        assertThat(uf.toString(), equalTo("[0, 1, 2, 4, 4, 5, 4, 7, 8, 9]"));
        assertThat(uf.root(3), equalTo(4));
        assertThat(uf.root(6), equalTo(4));
        assertThat(uf.root(8), equalTo(8));
        assertThat(uf.maxUnion(), equalTo(3));
    }


    @Test
    void testWeightedUnion() {
        UnionFind uf = new UnionFind(10);
        uf.weightedUnion(3, 4);
        assertThat(uf.toString(), equalTo("[0, 1, 2, 3, 3, 5, 6, 7, 8, 9]"));
        uf.weightedUnion(6, 4);
        assertThat(uf.toString(), equalTo("[0, 1, 2, 3, 3, 5, 3, 7, 8, 9]"));
        uf.weightedUnion(3, 6);
        assertThat(uf.toString(), equalTo("[0, 1, 2, 3, 3, 5, 3, 7, 8, 9]"));
        assertThat(uf.root(3), equalTo(3));
        assertThat(uf.root(6), equalTo(3));
        assertThat(uf.root(8), equalTo(8));
        assertThat(uf.maxUnion(), equalTo(3));
    }
}
