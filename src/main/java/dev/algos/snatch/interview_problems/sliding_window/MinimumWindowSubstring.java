package dev.algos.snatch.interview_problems.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 * Example 2:
 * <p>
 * Input: String="abdabca", Pattern="abc"
 * Output: "abc"
 * Explanation: The smallest substring having all characters of the pattern is "abc".
 * Example 3:
 * <p>
 * Input: String="adcad", Pattern="abc"
 * Output: ""
 * Explanation: No substring in the given string has all characters of the pattern.
 */
public class MinimumWindowSubstring {

    /**
     * Time Complexity
     * The time complexity of the above algorithm will be O(N + M)
     * where ‘N’ and ‘M’ are the number of characters in the input string and the pattern respectively.
     * <p>
     * Space Complexity
     * The space complexity of the algorithm is O(M)
     * since in the worst case, the whole pattern can have distinct characters which will go into the HashMap.
     * In the worst case, we also need O(N) space for the resulting substring,
     * which will happen when the input string is a permutation of the pattern.
     */
    String findSubstring(String str, String pattern) {
        if (str == null || pattern == null) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0, count = map.size(), len = str.length() + 1, resIndex = -1;
        while (end < str.length()) {
            char endChar = str.charAt(end++);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    count--;
                }
            }
            while (count == 0) {
                if (end - start < len && end - start >= pattern.length()) {
                    len = end - start;
                    resIndex = start;
                }
                char startChar = str.charAt(start++);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) == 1) {
                        count++;
                    }
                }
            }
        }
        return resIndex == -1 ? "" : str.substring(resIndex, resIndex + len);
    }
}
