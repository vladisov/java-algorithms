package dev.algos.snatch.data_structures.hash_table;

import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<K, V> {

    private LinkedList<Entry<K, V>>[] arr;
    private int size = 0;
    private float loadFactor;

    public HashTable() {
        this.arr = new LinkedList[16];
        this.loadFactor = 0.75f;
    }

    public HashTable(float loadFactor) {
        this.arr = new LinkedList[16];
        this.loadFactor = loadFactor;
    }

    public V get(K key) {
        int index = hash(key.hashCode(), arr.length);
        LinkedList<Entry<K, V>> entries = this.arr[index];
        if (entries == null) return null;

        for (HashTable.Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public V put(K key, V value) {
        this.checkExtension();
        int index = hash(key.hashCode(), arr.length);
        LinkedList<Entry<K, V>> entries = this.arr[index];
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (entries == null) {
            entries = new LinkedList<>();
            this.arr[index] = entries;
        }
        for (HashTable.Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                V old = entry.getValue();
                entry.setValue(value);
                return old;
            }
        }
        size++;
        entries.add(newEntry);
        return null;
    }

    public V remove(K key) {
        int index = hash(key.hashCode(), arr.length);
        LinkedList<Entry<K, V>> entries = this.arr[index];
        if (entries == null) return null;

        Iterator<Entry<K, V>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.getKey().equals(key)) {
                iterator.remove();
                size--;
                checkShrink();
                return entry.getValue();
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    private void checkExtension() {
        if (arr.length * loadFactor > size) {
            return;
        }
        int n = arr.length * 2;
        rebuildArray(n);
    }

    private void rebuildArray(int n) {
        LinkedList<Entry<K, V>>[] newArr = new LinkedList[n];
        for (var list : arr) {
            if (list != null && !list.isEmpty()) {
                int hash = hash(list.getFirst().getKey().hashCode(), n);
                newArr[hash] = list;
            }
        }
        this.arr = newArr;
    }

    private void checkShrink() {
        if (arr.length * .25 < size) {
            return;
        }
        int n = arr.length / 2;
        rebuildArray(n);
    }

    private int hash(int hashcode, int len) {
        return hashcode % len;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LinkedList<Entry<K, V>> entries : arr) {
            if (entries != null) {
                for (Entry<K, V> entry : entries) {
                    sb.append(entry.toString()).append(",");
                }
            }
        }
        if (sb.length() > 2) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

    static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }
}
