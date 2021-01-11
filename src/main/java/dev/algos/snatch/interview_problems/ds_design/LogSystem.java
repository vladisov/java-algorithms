package dev.algos.snatch.interview_problems.ds_design;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public class LogSystem {
    TreeMap<LocalDateTime, Integer> logs;

    public LogSystem() {
        logs = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        LocalDateTime date = parseDate(timestamp);
        logs.put(date, id);
    }

    @NotNull
    private LocalDateTime parseDate(String timestamp) {
        String[] split = timestamp.split(":");
        return LocalDateTime.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]),
                Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]));
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        LocalDateTime startTime = parseDate(start);
        LocalDateTime endTime = parseDate(end);
        switch (granularity) {
            case "Year":
                startTime = startTime.withMonth(1).withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
                endTime = endTime.withMonth(12).with(lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59);
                break;
            case "Month":
                startTime = startTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
                endTime = endTime.with(lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59);
                break;
            case "Day":
                startTime = startTime.withHour(0).withMinute(0).withSecond(0);
                endTime = endTime.withHour(23).withMinute(59).withSecond(59);
                break;
            case "Hour":
                startTime = startTime.withMinute(0).withSecond(0);
                endTime = endTime.withMinute(59).withSecond(59);
                break;
            case "Minute":
                startTime = startTime.withSecond(0);
                endTime = endTime.withSecond(59);
                break;
        }
        return new ArrayList<>(logs.subMap(startTime, true, endTime, true).values());
    }
}
