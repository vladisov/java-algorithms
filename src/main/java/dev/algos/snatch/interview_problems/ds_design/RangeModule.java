package dev.algos.snatch.interview_problems.ds_design;


/*

5,8  10,20 -> 14,16

removal ->

find end > currEnd
find start < currStart
remove (merge)

add ->

*/

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class RangeModule {

    private final TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }

    /*
    5 10 10 12 13 16  |  8 14
     */
    public void addRange(int left, int right) {
        Integer leftStart = map.floorKey(left);
        Integer rightStart = map.floorKey(right);

        if (leftStart != null) {
            int leftEnd = map.get(leftStart);
            if (leftEnd >= left) {
                map.put(leftStart, Math.max(right, leftEnd));
                left = leftStart;
            } else {
                map.put(left, right);
            }
        }
        if (rightStart != null) {
            int rightEnd = map.get(rightStart);
            right = Math.max(rightEnd, right);
            map.put(left, right);
        }
        if (rightStart != null || leftStart != null) {
            Map<Integer, Integer> subMap = map.subMap(left, right);
            Set<Integer> keys = new HashSet<>(subMap.keySet());
            map.keySet().removeAll(keys);
        }
        map.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer leftStart = map.floorKey(left);
        Integer rightStart = map.floorKey(right);
        if (leftStart != null && rightStart != null) {
            Map<Integer, Integer> subMap = map.subMap(leftStart, true, rightStart, true);
            if (subMap.isEmpty()) return false;
            Integer prev = null;
            for (var entry : subMap.entrySet()) {
                int l = entry.getKey();
                if (prev != null) {
                    if (l - prev > 1) return false;
                }
                prev = entry.getValue();
            }
            return right - prev <= 1;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        if (right <= left) return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (end != null && map.get(end) > right) {
            map.put(right, map.get(end));
        }
        if (start != null && map.get(start) > left) {
            map.put(start, left);
        }
        Map<Integer, Integer> subMap = map.subMap(left, true, right, false);
        Set<Integer> set = new HashSet<>(subMap.keySet());
        map.keySet().removeAll(set);
    }
}

