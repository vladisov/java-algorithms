package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 */
public class PascalsTriangle_2 {

    /**
     * Time O(N^2)
     * Space O(K) - number of integers in previous row
     */
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of(1);
        Stack<List<Integer>> stack = new Stack<>();
        stack.add(List.of(1));
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int sums = i - 1;
            List<Integer> prevRow = stack.pop();
            for (int j = 0; j < sums; j++) {
                list.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            list.add(1);
            stack.add(list);
        }
        return stack.pop();
    }
}
