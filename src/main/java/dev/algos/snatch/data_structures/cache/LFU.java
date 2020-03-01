package dev.algos.snatch.data_structures.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;

public class LFU<K, V> implements Cache<K, V> {
    private int capacity, min;
    private Map<K, V> values;
    private Map<K, Integer> counts;
    //map count -> dll
    private Map<Integer, LinkedHashSet<K>> lists;

    public LFU(int capacity) {
        this.min = -1;
        this.capacity = capacity;
        this.values = new HashMap<>();
        this.counts = new HashMap<>();
        this.lists = new HashMap<>();
        this.lists.put(1, new LinkedHashSet<>());
    }

    /**
     * Time complexity O(1)
     */
    public void put(K key, V value) {
        if (capacity <= 0) return;
        //if element exists
        if (values.containsKey(key)) {
            values.put(key, value);
            get(key); //rearrange
            return;
        }
        //if element needs to be evicted
        if (size() >= capacity) {
            K evict = lists.get(min).iterator().next();
            lists.get(min).remove(evict);
            values.remove(evict);
        }
        //if element does not exist
        values.put(key, value);
        min = 1;
        counts.put(key, min);
        lists.get(1).add(key);
    }

    /**
     * Time complexity O(1)
     */
    public V get(K key) {
        if (!values.containsKey(key)) {
            throw new NoSuchElementException();
        }
        int count = counts.get(key);
        int newCount = count + 1;
        counts.put(key, newCount);
        lists.get(count).remove(key);
        //update min count if there are no dll with such count
        if (min == count && this.lists.get(count).size() == 0) {
            min++;
        }
        if (!lists.containsKey(newCount)) {
            lists.put(newCount, new LinkedHashSet<>());
        }
        lists.get(newCount).add(key);
        return values.get(key);
    }

    @Override
    public String toString() {
        return values.toString();
    }

    public int size() {
        return values.size();
    }
}
