package dev.algos.snatch.data_structures.cache;

import dev.algos.snatch.data_structures.cache.util.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LRU_DLL<K, V> implements Cache<K, V> {
    private Map<K, ListNode<K, V>> map;
    private ListNode<K, V> dummyHead;
    private ListNode<K, V> dummyTail;
    private int capacity;

    public LRU_DLL(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new ListNode<>(null, null);
        dummyTail = new ListNode<>(null, null);
        dummyHead.next = dummyTail;
    }

    /**
     * Time complexity O(1)
     */
    public void put(K key, V value) {
        ListNode<K, V> node = new ListNode<>(key, value);
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        map.put(key, node);
        addToHead(node);

        if (map.size() > capacity) {
            evictLast();
        }
    }

    private void addToHead(ListNode<K, V> node) {
        var tmp = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        node.next = tmp;
        tmp.prev = node;
    }

    private void removeNode(ListNode<K, V> node) {
        ListNode<K, V> prev = node.prev;
        ListNode<K, V> next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void evictLast() {
        if (map.size() == 0) {
            return;
        }
        var last = dummyTail.prev;
        var tmp = last.prev;
        tmp.next = dummyTail;
        dummyTail.prev = tmp;
        map.remove(last.key);
    }

    /**
     * Time complexity O(1)
     */
    public V get(K key) {
        if (!map.containsKey(key)) {
            throw new NoSuchElementException(key.toString());
        }
        ListNode<K, V> node = map.get(key);
        if (node.prev != dummyHead) {
            ListNode<K, V> prev = node.prev;
            prev.next = node.next;
            node.next.prev = prev;
            addToHead(node);
        }
        return node.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        var node = dummyHead.next;
        sb.append("[");
        while (node != dummyTail) {
            sb.append(node.value.toString()).append(", ");
            node = node.next;
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return map.size();
    }
}
