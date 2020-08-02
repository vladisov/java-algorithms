package dev.algos.snatch.interview_problems.miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistorySetTest {

    @Test
    void testMemberOptimized() {
        HistorySet<String> historySet = new HistorySetMemberOptimized<>();
        assertEquals(0, historySet.add("a"));
        assertEquals(1, historySet.add("b"));
        assertEquals(2, historySet.add("c"));
        assertEquals(3, historySet.discard("b"));

        assertEquals(List.of("a"), historySet.member(0));
        assertEquals(List.of("a", "b"), historySet.member(1));
        assertEquals(List.of("a", "b", "c"), historySet.member(2));
        assertEquals(List.of("a", "c"), historySet.member(3));
    }

    @Test
    void testAddDiscardOptimized() {
        HistorySet<String> historySet = new HistorySetAddDiscardOptimized<>();
        assertEquals(0, historySet.add("a"));
        assertEquals(1, historySet.add("b"));
        assertEquals(2, historySet.add("c"));
        assertEquals(3, historySet.discard("b"));

        assertEquals(List.of("a"), historySet.member(0));
        assertEquals(List.of("a", "b"), historySet.member(1));
        assertEquals(List.of("a", "b", "c"), historySet.member(2));
        assertEquals(List.of("a", "c"), historySet.member(3));
    }
}
