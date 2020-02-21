package dev.algos.snatch.data_structures.tree;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BinarySearchTreeTest {


    @Test
    void testInsertInteger() {
        var tree = new BinarySearchTree<Integer>(Comparator.comparingInt(i -> i));
        tree.add(1);
        tree.add(2);
        tree.add(-1);
        assertThat(tree.printInOrder(), equalTo("[-1,1,2]"));
        tree.add(5);
        tree.add(-6);
        tree.add(-2);
        tree.add(-1);
        tree.add(8);
        tree.add(4);
        assertThat(tree.printInOrder(), equalTo("[-6,-2,-1,1,2,4,5,8]"));
    }

    @Test
    void testSearch() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Comparator.comparingInt(i -> i));
        tree.add(1);
        tree.add(2);
        tree.add(-1);
        assertThat(tree.printInOrder(), equalTo("[-1,1,2]"));
        tree.add(5);
        tree.add(-6);
        tree.add(-2);
        tree.add(-1);
        tree.add(8);
        tree.add(4);
        assertThat(tree.printInOrder(), equalTo("[-6,-2,-1,1,2,4,5,8]"));

        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(8));
        assertFalse(tree.search(7));
        assertFalse(tree.search(6));
    }

    @Test
    void testDelete() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(Comparator.comparingInt(i -> i));
        tree.add(1);
        tree.add(2);
        tree.add(-1);
        assertThat(tree.printInOrder(), equalTo("[-1,1,2]"));
        tree.add(5);
        tree.add(-6);
        tree.add(-2);
        tree.add(-1);
        tree.add(8);
        tree.add(4);
        assertThat(tree.printInOrder(), equalTo("[-6,-2,-1,1,2,4,5,8]"));
        assertTrue(tree.delete(1));
        assertFalse(tree.search(1));
        assertTrue(tree.delete(2));
        assertFalse(tree.search(2));
        assertTrue(tree.delete(-1));
        assertFalse(tree.search(-1));
        assertTrue(tree.delete(-6));
        assertFalse(tree.search(-6));
        assertFalse(tree.delete(101));
    }
}
