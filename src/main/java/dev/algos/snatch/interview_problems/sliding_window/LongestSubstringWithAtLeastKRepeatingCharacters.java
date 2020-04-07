package dev.algos.snatch.interview_problems.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "aaabb", k = 3
 * <p>
 * Output:
 * 3
 * <p>
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * <p>
 * Input:
 * s = "ababbc", k = 2
 * <p>
 * Output:
 * 5
 * <p>
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /**
     * Time O(26 * N)
     * Space O(N)
     */
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int len = 0;
        for (int numUnique = 1; numUnique <= 26; numUnique++) {
            len = Math.max(longestSubstring(s, k, numUnique), len);
        }
        return len;
    }


    private int longestSubstring(String s, int k, int numUnique) {
        int start = 0, end = 0, len = 0, noLessThanK = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            char endChar = s.charAt(end++);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            if (map.get(endChar) == k) {
                noLessThanK++;
            }

            while (map.size() > numUnique) {
                char startChar = s.charAt(start++);
                if (map.get(startChar) == k) {
                    noLessThanK--;
                }
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }
            }

            if (map.size() == numUnique && noLessThanK == numUnique) {
                len = Math.max(end - start, len);
            }
        }
        return len;
    }
}
