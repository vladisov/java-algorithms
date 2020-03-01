package dev.algos.snatch.data_structures.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LRUCache {
    private Map<Integer, ListNode> map;
    private ListNode dummyHead;
    private ListNode dummyTail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new ListNode(null, null);
        dummyTail = new ListNode(null, null);
        dummyHead.next = dummyTail;
    }

    public void put(Integer key, Integer value) {
        ListNode node = new ListNode(key, value);
        if (map.containsKey(key)) {
            map.put(key, node);
        } else {
            map.put(key, node);
            size++;
        }
        addToHead(node);
        if (size > capacity) {
            evictLast();
        }
    }

    private void addToHead(ListNode node) {
        var tmp = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        node.next = tmp;
        tmp.prev = node;
    }

    private void removeNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void evictLast() {
        if (size == 0) {
            return;
        }
        var last = dummyTail.prev;
        var tmp = last.prev;
        tmp.next = dummyTail;
        dummyTail.prev = tmp;
        map.remove(last.key);
        size--;
    }

    public Integer get(Integer key) {
        if (!map.containsKey(key)) {
            throw new NoSuchElementException(key.toString());
        }
        ListNode node = map.get(key);
        if (node.prev != dummyHead) {
            ListNode prev = node.prev;
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

    public int getSize() {
        return size;
    }

    private static class ListNode {
        public Integer key;
        public Integer value;
        public ListNode next;
        public ListNode prev;

        public ListNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

    }
}
