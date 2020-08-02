package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * Design a data structure for History Set with following operations:
 * <p>
 * Add(element) : Adds an element to the Set and returns a SequenceId
 * Discard(element): Discards an element from the Set and returns a SequenceId
 * Member(sequenceId): Return the state of historySet at a given sequenceId
 * Example:
 * seq1 = add("a")
 * seq2 = add("b")
 * seq3 = add("c")
 * seq4 = discard("b")
 * <p>
 * member(seq3) = ("a", "b", "c")
 * member(seq1) = ("a")
 * member(seq4) = ("a", "c")
 */
public class HistorySetMemberOptimized<T> implements HistorySet<T> {

    private final Map<Integer, List<T>> historyMap;
    private final LinkedHashSet<T> objectSet;
    private int sequenceId;

    public HistorySetMemberOptimized() {
        this.historyMap = new HashMap<>();
        this.objectSet = new LinkedHashSet<>();
    }

    /**
     * O(N) N here depends on number of already removed
     */
    @Override
    public int add(T object) {
        objectSet.add(object);
        return addHistory();
    }

    /**
     * O(N)
     */
    @Override
    public int discard(T object) {
        objectSet.remove(object);
        return addHistory();
    }

    private int addHistory() {
        historyMap.put(sequenceId, new ArrayList<>(objectSet));
        return sequenceId++;
    }

    /**
     * O(1)
     */
    @Override
    public List<T> member(int sequenceId) {
        return historyMap.getOrDefault(sequenceId, List.of());
    }
}
