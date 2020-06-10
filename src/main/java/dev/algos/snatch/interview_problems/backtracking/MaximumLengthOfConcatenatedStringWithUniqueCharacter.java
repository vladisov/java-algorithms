package dev.algos.snatch.interview_problems.backtracking;

import java.util.List;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 * <p>
 * Return the maximum possible length of s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 * <p>
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 * <p>
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 */
public class MaximumLengthOfConcatenatedStringWithUniqueCharacter {

    /**
     * Time O(2^N * L)
     * Space O(N) for rec stack
     */
    public int maxLength(List<String> arr) {
        return helper(arr, 0, new int[26]);
    }

    int helper(List<String> arr, int index, int[] visited) {
        if (index == arr.size()) {
            return 0;
        }
        boolean unique = markVisited(arr.get(index), visited);
        int c1 = 0;
        if (unique) {
            c1 = arr.get(index).length() + helper(arr, index + 1, visited);
        }
        unmarkVisited(arr.get(index), visited);

        int c2 = helper(arr, index + 1, visited);

        return Math.max(c1, c2);
    }

    boolean markVisited(String str, int[] visited) {
        boolean unique = true;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (visited[index] != 0) {
                unique = false;
            }
            visited[index]++;
        }
        return unique;
    }

    void unmarkVisited(String str, int[] visited) {
        for (int i = 0; i < str.length(); i++) {
            visited[str.charAt(i) - 'a']--;
        }
    }
}
