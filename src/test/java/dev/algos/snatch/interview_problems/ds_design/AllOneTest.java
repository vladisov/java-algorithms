package dev.algos.snatch.interview_problems.ds_design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllOneTest {

    @Test
    void test() {
        AllOne allOne = new AllOne();
        allOne.inc("key1");
        assertEquals("key1", "key1");
        assertEquals("key1", "key1");
        allOne.dec("key1");
        assertEquals("", allOne.getMinKey());
        assertEquals("", allOne.getMaxKey());
        allOne.inc("key1");
        allOne.inc("key1");
        allOne.inc("key1");
        allOne.inc("key2");
        allOne.inc("key2");
        allOne.inc("key3");
        assertEquals("key3", allOne.getMinKey());
        assertEquals("key1", allOne.getMaxKey());
        allOne.dec("key1");
        allOne.dec("key1");
        assertEquals("key2", allOne.getMaxKey());
    }

    @Test
    void test1() {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        assertEquals("hello", allOne.getMaxKey());
        assertEquals("hello", allOne.getMinKey());
    }

    @Test
    void test2() {
        AllOne allOne = new AllOne();
        allOne.inc("b");
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("a");
        allOne.dec("a");
        assertEquals("a", allOne.getMaxKey());
        assertEquals("b", allOne.getMinKey());
    }

    @Test
    void test3() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.dec("a");
        assertEquals("b", allOne.getMaxKey());
        assertEquals("a", allOne.getMinKey());
    }
}
