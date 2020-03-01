package dev.algos.snatch.data_structures.cache;

public interface Cache<K, V> {
    void put(K key, V value);

    V get(K key);

    int size();
}
