package dev.algos.snatch.interview_problems.helpers;

import java.util.LinkedList;
import java.util.List;

public class Job {
    private int start;
    private int end;
    private int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }

    public static List<Job> buildList(String str) {
        List<Job> result = new LinkedList<>();
        str = str.substring(1, str.length() - 1);
        String[] split = str.split("],\\s\\[");
        for (String s : split) {
            String replaced = s.replaceAll("[\\[\\]]", "");
            String[] numbers = replaced.split(",\\s*");
            result.add(new Job(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2])));
        }
        return result;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getCpuLoad() {
        return cpuLoad;
    }

    @Override
    public String toString() {
        return "[" +
                start +
                ", " +
                end +
                ", " +
                cpuLoad +
                "]";
    }
};
