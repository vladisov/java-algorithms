package dev.algos.snatch.interview_problems.ds_design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

    Map<String, List<TimeValue>> map;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        this.map = new HashMap<>();
    }

    /**
     * O(1)
     */
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new TimeValue(timestamp, value));
    }

    /**
     * O(LogN)
     */
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        var values = map.get(key);
        return search(values, timestamp);
    }

    private String search(List<TimeValue> values, int target) {
        int lo = 0, hi = values.size() - 1;
        String res = "";
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (values.get(mid).timestamp == target) {
                return values.get(mid).value;
            }
            if (values.get(mid).timestamp < target) {
                lo = mid + 1;
                res = values.get(mid).value;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    static class TimeValue {
        int timestamp;
        String value;

        public TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

//using treemap
class TimeMap2 {

    Map<String, TreeMap<Integer, String>> map;

    /**
     * Initialize your data structure here.
     */
    public TimeMap2() {
        this.map = new HashMap<>();
    }

    /**
     * O(1)
     */
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    /**
     * O(LogN)
     */
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        return map.get(key).floorEntry(timestamp).getValue();
    }
}
