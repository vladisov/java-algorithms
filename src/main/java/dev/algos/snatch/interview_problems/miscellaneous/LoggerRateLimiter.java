package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public interface LoggerRateLimiter {
    boolean shouldPrintMessage(int timestamp, String message);
}

class LoggerRateLimiterMap implements LoggerRateLimiter {

    private final Map<String, Integer> map;

    public LoggerRateLimiterMap() {
        map = new HashMap<>();
    }

    /**
     * Time O(1)
     * Space O(N) growing
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        var prev = map.get(message);
        if (prev == null || timestamp - prev >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}


class LoggerRateLimiterQueue implements LoggerRateLimiter {
    private final Queue<Item> queue;
    private final Set<String> set;

    public LoggerRateLimiterQueue() {
        queue = new ArrayDeque<>();
        set = new HashSet<>();
    }

    /**
     * O(M) m number of unique messages or O(N) - worst case because we'll need to iterate through all in the window
     * O(1) space
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && queue.peek().time <= timestamp - 10) {
            set.remove(queue.poll().message);
        }
        if (set.contains(message)) {
            return false;
        }
        queue.add(new Item(timestamp, message));
        set.add(message);
        return true;
    }

    static class Item {
        int time;
        String message;

        public Item(int time, String message) {
            this.time = time;
            this.message = message;
        }
    }
}
