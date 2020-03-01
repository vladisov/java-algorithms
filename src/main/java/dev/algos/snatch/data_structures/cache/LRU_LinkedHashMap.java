package dev.algos.snatch.data_structures.cache;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static dev.algos.snatch.interview_problems.helpers.ArrayUtils.reverse;

public class LRU_LinkedHashMap<K, V> implements Cache<K, V> {
    private LinkedHashMap<K, V> map;

    public LRU_LinkedHashMap(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            throw new NoSuchElementException(key.toString());
        }
        return map.get(key);
    }

    @Override
    public String toString() {
        var arr = map.values().toArray();
        reverse(arr);
        return Arrays.toString(arr);
    }

    public int size() {
        return map.size();
    }
}
