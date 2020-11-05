package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup (250ml) of champagne.
 * <p>
 * Then, some champagne is poured in the first glass at the top.  When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)
 * <p>
 * For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.
 * <p>
 * <p>
 * <p>
 * Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: poured = 1, query_row = 1, query_glass = 1
 * Output: 0.00000
 * Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the top glass will remain empty.
 */
public class ChampagneTower {

    /**
     * Time & Space O(100 * 100 + 1) = O(1)
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        Map<Integer, double[]> map = new HashMap<>();
        map.put(0, new double[]{poured});
        for (int row = 0; row < 100; row++) {
            map.putIfAbsent(row + 1, new double[row + 2]);
            for (int col = 0; col < row + 1; col++) {
                double full = map.get(row)[col];
                int left = col, right = col + 1;
                if (full > 1.0) {
                    double diff = full - 1.0;
                    double split = diff / 2;
                    map.get(row)[col] -= diff;
                    map.get(row + 1)[left] += split;
                    map.get(row + 1)[right] += split;
                }
            }
        }
        return map.get(query_row)[query_glass];
    }
}
