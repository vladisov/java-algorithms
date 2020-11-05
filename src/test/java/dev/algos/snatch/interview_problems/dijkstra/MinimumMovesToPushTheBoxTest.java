package dev.algos.snatch.interview_problems.dijkstra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumMovesToPushTheBoxTest {

    @Test
    void test() {

        MinimumMovesToPushTheBox inst = new MinimumMovesToPushTheBox();
        assertEquals(3, inst.minPushBox(new char[][]
                {
                        {'#', '#', '#', '#', '#', '#'},
                        {'#', 'T', '#', '#', '#', '#'},
                        {'#', '.', '.', 'B', '.', '#'},
                        {'#', '.', '#', '#', '.', '#'},
                        {'#', '.', '.', '.', 'S', '#'},
                        {'#', '#', '#', '#', '#', '#'}
                }));
        assertEquals(7, inst.minPushBox(new char[][]
                {
                        {'#', '.', '.', '#', '#', '#', '#', '#'},
                        {'#', '.', '.', 'T', '#', '.', '.', '#'},
                        {'#', '.', '.', '.', '#', 'B', '.', '#'},
                        {'#', '.', '.', '.', '.', '.', '.', '#'},
                        {'#', '.', '.', '.', '#', '.', 'S', '#'},
                        {'#', '.', '.', '#', '#', '#', '#', '#'}
                }));
        assertEquals(8, inst.minPushBox(new char[][]
                {
                        {'#', '.', '.', '#', 'T', '#', '#', '#', '#'},
                        {'#', '.', '.', '#', '.', '#', '.', '.', '#'},
                        {'#', '.', '.', '#', '.', '#', 'B', '.', '#'},
                        {'#', '.', '.', '.', '.', '.', '.', '.', '#'},
                        {'#', '.', '.', '.', '.', '#', '.', 'S', '#'},
                        {'#', '.', '.', '#', '.', '#', '#', '#', '#'}
                }));
    }
}
