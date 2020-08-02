package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.List;

public interface HistorySet<T> {

    int add(T object);

    int discard(T object);

    List<T> member(int sequenceId);
}
