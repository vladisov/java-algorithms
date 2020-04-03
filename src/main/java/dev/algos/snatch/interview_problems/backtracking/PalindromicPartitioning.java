package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromicPartitioning {

    /**
     * Time O(n*(2^n))
     * <p>
     * Time complexity: O(n*(2^n))
     * For a string with length n, there will be (n - 1) intervals between chars.
     * For every interval, we can cut it or not cut it, so there will be 2^(n - 1) ways to partition the string.
     * For every partition way, we need to check if it is palindrome, which is O(n).
     * So the time complexity is O(n*(2^n))
     * <p>
     * For every partition way we also need to make a copy of the partitioning to put in the output, this is O(N)
     * So the final runtime is O(2^n * n^2)
     * <p>
     * Space O(2^N)
     */
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return List.of(List.of());
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), new ArrayList<>(), result);
        return result;
    }

    void backtrack(String s, int start, StringBuilder sb, List<String> tmp, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tmp.add(s.substring(start, i + 1));
                backtrack(s, i + 1, sb, tmp, result);
                tmp.remove(tmp.size() - 1);

            }
        }
    }

    boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return false;
            }
        }
        return true;
    }
}
