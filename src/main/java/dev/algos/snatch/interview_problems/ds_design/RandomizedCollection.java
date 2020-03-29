package dev.algos.snatch.interview_problems.ds_design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection {

    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /*
    0 1 2 3 4 5 3 3

    3 -> 3, 6, 7

    */

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            list.add(val);
            map.get(val).add(list.size() - 1);
            return false;
        }
        list.add(val);
        map.put(val, new HashSet<>());
        map.get(val).add(list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Set<Integer> indexes = map.get(val);
        int index = indexes.iterator().next();
        indexes.remove(index);
        if (indexes.size() == 0) {
            map.remove(val);
        }
        list.remove(index);

        if (index != list.size()) {
            int lastOneIndex = list.size() - 1;
            int lastOne = list.get(lastOneIndex);
            list.remove(lastOneIndex);

            list.add(index, lastOne);
            if (map.containsKey(lastOne)) {
                map.get(lastOne).remove(lastOneIndex + 1);
            } else {
                map.put(lastOne, new HashSet<>());
            }
            map.get(lastOne).add(index);
        }

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
