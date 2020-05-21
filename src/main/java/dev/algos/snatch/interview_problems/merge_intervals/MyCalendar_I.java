package dev.algos.snatch.interview_problems.merge_intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendar_I {

    List<Event> list;
    TreeMap<Integer, Integer> calendar;

    public MyCalendar_I() {
        list = new ArrayList<>();
        calendar = new TreeMap<>(); // for another implementation
    }

    public boolean book(int start, int end) {
        Event event = new Event(start, end);
        if (book(event)) {
            return true;
        }
        return false;
    }

    /**
     * Time O(logN)
     */
    private boolean book(Event event) {
        if (list.isEmpty()) {
            list.add(event);
            return true;
        }
        //do bs here
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            Event midEvent = list.get(mid);
            if (isOverlap(event, midEvent)) {
                return false;
            }
            if (midEvent.end <= event.start) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        list.add(lo, event);
        return true;
    }

    boolean isOverlap(Event e1, Event e2) {
        return (e1.start <= e2.start && e1.end > e2.start) ||
                (e1.start < e2.end && e1.end > e2.start);
    }

    /**
     * Time O(logN)
     */
    public boolean bookTreeMap(int start, int end) {
        Integer floorKey = calendar.floorKey(start); // find closest start less than
        if (floorKey != null && calendar.get(floorKey) > start) return false; //if prev end > start
        Integer ceilingKey = calendar.ceilingKey(start); // find nex start
        if (ceilingKey != null && ceilingKey < end) return false; // if next start < end
        calendar.put(start, end);
        return true;
    }

    static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
