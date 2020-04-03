package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {

    /**
     * Time O(N^2)
     * Space O(n^2)
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return List.of();
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        if (numRows == 1) {
            return result;
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int sums = i - 2;
            List<Integer> prevRow = result.get(i - 2);
            for (int j = 0; j < sums; j++) {
                list.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
