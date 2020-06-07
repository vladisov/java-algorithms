package dev.algos.snatch.interview_problems.ds_design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implement a data structure supporting the following operations:
 * <p>
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 */
public class AllOne {
    private final Value dummyHead;
    private final Value dummyTail;
    private final Map<String, Value> keyMap;
    private final Map<Integer, Value> valueCounts;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        dummyTail = new Value(0);
        dummyHead = new Value(0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        keyMap = new HashMap<>();
        valueCounts = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     * Time O(1)
     */
    public void inc(String key) {
        int count;
        Value value;
        Value prev = keyMap.get(key);
        if (keyMap.containsKey(key)) {
            count = prev.count + 1;
            prev.keys.remove(key);
        } else {
            count = 1;
        }

        boolean containsCount = valueCounts.containsKey(count);
        if (containsCount) {
            value = valueCounts.get(count);
        } else {
            value = new Value(count);
            valueCounts.put(count, value);
        }
        if (!containsCount) {
            if (count == 1) {
                insertFirst(value);
            } else {
                insertAfter(value, prev);
            }
        }
        value.keys.add(key);
        keyMap.put(key, value);

        if (prev != null && prev.keys.isEmpty()) {
            remove(prev);
            valueCounts.remove(prev.count);
        }
    }

    //prev val prev next
    private void insertAfter(Value value, Value prev) {
        prev.next.prev = value;
        value.next = prev.next;
        prev.next = value;
        value.prev = prev;
    }

    private void insertFirst(Value value) {
        value.next = dummyHead.next;
        value.next.prev = value;
        dummyHead.next = value;
        value.prev = dummyHead;
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     * Time O(1)
     */
    public void dec(String key) {
        if (!keyMap.containsKey(key)) {
            return;
        }
        Value value = keyMap.get(key);
        int count = value.count - 1;
        if (count <= 1) {
            if (value.keys.size() == 1) {
                remove(value);
            } else {
                value.keys.remove(key);
            }
            valueCounts.remove(value.count);
            keyMap.remove(key);
        } else {
            if (valueCounts.containsKey(count)) {
                valueCounts.get(count).keys.add(key);
                keyMap.put(key, valueCounts.get(count));
            } else {
                Value newValue = new Value(count);
                newValue.keys.add(key);
                valueCounts.put(count, newValue);
                keyMap.put(key, newValue);
                insertBefore(value, newValue);
            }
            value.keys.remove(key);
            if (value.keys.isEmpty()) {
                remove(value);
                valueCounts.remove(value.count);
            }
        }
    }

    private void insertBefore(Value value, Value newValue) {
        value.prev.next = newValue;
        newValue.prev = value.prev;
        newValue.next = value;
        value.prev = newValue;
    }

    private void remove(Value value) {
        value.prev.next = value.next;
        value.next.prev = value.prev;
    }

    /*
    key -> value
    [value: key] [value: [keys]]
    min, max
    value1
    value2
    // value3
    value4
    value5
    */

    /**
     * Returns one of the keys with maximal value.
     * Time O(1)
     */
    public String getMaxKey() {
        Value maxValue = dummyTail.prev;
        if (maxValue != null && !maxValue.keys.isEmpty()) {
            return maxValue.keys.iterator().next();
        }
        return "";
    }

    /**
     * Returns one of the keys with Minimal value.
     * Time O(1)
     */
    public String getMinKey() {
        Value minValue = dummyHead.next;
        if (minValue != null && !minValue.keys.isEmpty()) {
            return minValue.keys.iterator().next();
        }
        return "";
    }

    static class Value {
        Value prev;
        Value next;
        int count;
        Set<String> keys;

        public Value(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }
}
