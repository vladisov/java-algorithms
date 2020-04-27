package dev.algos.snatch.data_structures.union_find;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisjointSetTest {

    @Test
    void test() {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        assertEquals(4, ds.findSet(1));
        assertEquals(4, ds.findSet(2));
        assertEquals(4, ds.findSet(3));
        assertEquals(4, ds.findSet(4));
        assertEquals(4, ds.findSet(5));
        assertEquals(4, ds.findSet(6));
        assertEquals(4, ds.findSet(7));
    }
}
