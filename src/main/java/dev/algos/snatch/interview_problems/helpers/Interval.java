package dev.algos.snatch.interview_problems.helpers;

import java.util.LinkedList;
import java.util.List;

public class Interval {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static List<Interval> buildList(String str) {
        List<Interval> result = new LinkedList<>();
        str = str.substring(1, str.length() - 1);
        String[] split = str.split("],\\s\\[");
        for (String s : split) {
            String replaced = s.replaceAll("[\\[\\]]", "");
            String[] numbers = replaced.split(",\\s");
            result.add(new Interval(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])));
        }
        return result;
    }

    public static Interval[] buildArray(String str) {
        List<Interval> intervals = buildList(str);
        Interval[] result = new Interval[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            result[i] = intervals.get(i);
        }
        return result;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "[" +
                start +
                ", " +
                end +
                "]";
    }
};
