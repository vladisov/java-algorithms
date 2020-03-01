package dev.algos.snatch.data_structures.cache.util;

public class ListNode<K, V> {
    public K key;
    public V value;
    public int frequency;
    public ListNode<K, V> next;
    public ListNode<K, V> prev;

    public ListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        String keyStr = key == null ? "null" : key.toString();
        String valStr = value == null ? "null" : value.toString();
        return "[" + keyStr + ", " + valStr + "]";
    }
}
