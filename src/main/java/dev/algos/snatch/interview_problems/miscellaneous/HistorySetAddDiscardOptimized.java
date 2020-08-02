package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class HistorySetAddDiscardOptimized<T> implements HistorySet<T> {

    private int sequenceId;
    private LinkedHashMap<Integer, Entry<T>> objectMap;

    public HistorySetAddDiscardOptimized() {
        this.objectMap = new LinkedHashMap<>();
    }

    /**
     * O(1)
     */
    @Override
    public int add(T object) {
        return addEntry(object, false);
    }

    /**
     * O(1)
     */
    @Override
    public int discard(T object) {
        return addEntry(object, true);
    }

    /**
     * O(N)
     */
    private int addEntry(T object, boolean discard) {
        Entry<T> entry = new Entry<>(object, discard);
        objectMap.put(sequenceId, entry);
        return sequenceId++;
    }

    @Override
    public List<T> member(int sequenceId) {
        LinkedHashSet<T> set = new LinkedHashSet<>();
        for (int i = 0; i <= sequenceId; i++) {
            var entry = objectMap.get(i);
            if (entry.isDiscard()) {
                set.remove(entry.getObject());
            } else {
                set.add(entry.getObject());
            }
        }
        return new ArrayList<>(set);
    }

    static class Entry<T> {
        private T object;
        private boolean discard;

        public Entry(T object, boolean discard) {
            this.object = object;
            this.discard = discard;
        }

        public T getObject() {
            return object;
        }

        public boolean isDiscard() {
            return discard;
        }
    }
}
