package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {

    /**
     * Time O(n^k)
     * Space O(n^k)
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, result, new ArrayList<>());
        return result;
    }

    void backtrack(int n, int k, int start, List<List<Integer>> result, List<Integer> tmp) {
        if (k == 0) {
            result.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i <= n; i++) {
                tmp.add(i);
                backtrack(n, k - 1, i + 1, result, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
