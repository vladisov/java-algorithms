package dev.algos.snatch.data_structures.union_find;

import org.junit.jupiter.api.Test;

class UnionFindTest {


    @Test
    void test() {
        UnionFind uf = new UnionFind(10);
        uf.union(3, 4);
        uf.toString();
        uf.union(6, 4);
        uf.union(3, 6);
        uf.toString();
        System.out.println(uf.root(3));
        System.out.println(uf.root(6));
        System.out.println(uf.root(8));
        System.out.println(uf.maxUnion());
    }
}
