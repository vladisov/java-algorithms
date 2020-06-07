package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 * <p>
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 * <p>
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
 * <p>
 * We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
 * <p>
 * Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation:
 * The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 */
public class PrisonCellsAfterNDays {

    /**
     * Time O(2^6) = O(1)
     * Space O(1)
     */
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        while (N > 0) {
            int[] arr = new int[cells.length];
            String key = Arrays.toString(cells);
            map.put(key, N--);
            for (int j = 0; j < cells.length; j++) {
                if (j == 0 || j == cells.length - 1) {
                    arr[j] = 0;
                } else if (cells[j - 1] == cells[j + 1]) {
                    arr[j] = 1;
                } else {
                    arr[j] = 0;
                }
            }
            cells = arr;
            if (map.containsKey(Arrays.toString(cells))) {
                N %= (map.get(Arrays.toString(cells)) - N); // last seen - current val -> cycle len
            }
        }
        return cells;
    }
}
