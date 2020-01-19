package dev.algos.snatch.interview_problems.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring which has no repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 * Example 2:
 * <p>
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 * Example 3:
 * <p>
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 * Try it yourself #
 */
public class NoRepeatSubstring {

    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(k) <= O(n)
     * The space complexity of the algorithm will be O(K)
     * where K is the number of distinct characters in the input string.
     * This also means K<=N, because in the worst case,
     * the whole string might not have any repeating character
     * so the entire string will be added to the HashMap.
     * Having said that, since we can expect a fixed set of characters in the input string
     * (e.g., 26 for English letters),
     * we can say that the algorithm runs in fixed space O(1);
     * in this case, we can use a fixed-size array instead of the HashMap.
     */
    public int findLength(String s) {
        if (s == null) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0, maxLen = 0;
        while (end < s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
            }
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }

    int findLength1(String str) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int windowStart = 0, max = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charIndexMap.containsKey(c)) {
                windowStart = Math.max(windowStart, charIndexMap.get(c));
            }
            charIndexMap.put(c, i + 1);
            max = Math.max(max, i - windowStart + 1);
        }
        return max;
    }
}
