package dev.algos.snatch.interview_problems.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class NumberOfUniqueBST {

    /**
     * Time complexity O(N^2)
     * Space complexity O(N)
     */
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return numTreesRec(n, map);
    }

    int numTreesRec(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 1) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int left = numTreesRec(i - 1, map);
            int right = numTreesRec(n - i, map);
            count += left * right;
        }
        map.put(n, count);
        return count;
    }
}
