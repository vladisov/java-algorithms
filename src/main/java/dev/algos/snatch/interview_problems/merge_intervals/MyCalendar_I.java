package dev.algos.snatch.interview_problems.merge_intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.
 * <p>
 * Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
 * <p>
 * A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
 * <p>
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 * <p>
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * Example 1:
 * <p>
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * Explanation:
 * The first event can be booked.  The second can't because time 15 is already booked by another event.
 * The third event can be booked, as the first event takes every time less than 20, but not including 20.
 */
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
