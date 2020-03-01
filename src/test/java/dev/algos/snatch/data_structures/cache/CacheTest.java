package dev.algos.snatch.data_structures.cache;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CacheTest {
    Cache<Integer, Integer> lru_dll = new LRU_DLL<>(5);
    Cache<Integer, Integer> lru_lhm = new LRU_LinkedHashMap<>(5);
    Cache<Integer, Integer> lfu = new LFU<>(2);

    @Test
    void testLRUCache() {
        //doubly ll
        lru_dll.put(1, 1);
        lru_dll.put(2, 5);
        lru_dll.put(3, 10);
        lru_dll.put(4, 15);
        lru_dll.put(5, 25);
        assertThat(lru_dll.toString(), equalTo("[25, 15, 10, 5, 1]"));
        lru_dll.get(2);
        assertThat(lru_dll.toString(), equalTo("[5, 25, 15, 10, 1]"));
        lru_dll.get(1);
        assertThat(lru_dll.toString(), equalTo("[1, 5, 25, 15, 10]"));
        lru_dll.put(6, 30);
        assertThat(lru_dll.toString(), equalTo("[30, 1, 5, 25, 15]"));
        lru_dll.put(7, 40);
        lru_dll.put(8, 50);
        assertThat(lru_dll.toString(), equalTo("[50, 40, 30, 1, 5]"));

        assertThat(lru_dll.size(), equalTo(5));

        //linked hashmap
        lru_lhm.put(1, 1);
        lru_lhm.put(2, 5);
        lru_lhm.put(3, 10);
        lru_lhm.put(4, 15);
        lru_lhm.put(5, 25);
        assertThat(lru_lhm.toString(), equalTo("[25, 15, 10, 5, 1]"));
        lru_lhm.get(2);
        assertThat(lru_lhm.toString(), equalTo("[5, 25, 15, 10, 1]"));
        lru_lhm.get(1);
        assertThat(lru_lhm.toString(), equalTo("[1, 5, 25, 15, 10]"));
        lru_lhm.put(6, 30);
        assertThat(lru_lhm.toString(), equalTo("[30, 1, 5, 25, 15]"));
        lru_lhm.put(7, 40);
        lru_lhm.put(8, 50);
        assertThat(lru_lhm.toString(), equalTo("[50, 40, 30, 1, 5]"));

        assertThat(lru_dll.size(), equalTo(5));
    }

    @Test
    void testLFUCache() {
        //doubly ll
//        ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
//[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.get(1);
        lfu.put(3, 3);
        assertThrows(NoSuchElementException.class, () -> lfu.get(2));
        lfu.get(3);
//        assertThat(lfu.toString(), equalTo("[1, 3]"));

        lfu.put(4, 15);
        lfu.put(5, 25);
    }
}
