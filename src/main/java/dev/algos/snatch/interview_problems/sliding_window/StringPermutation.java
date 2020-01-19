package dev.algos.snatch.interview_problems.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * <p>
 * Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
 * <p>
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * If a string has ‘n’ distinct characters it will have n!n! permutations.
 * <p>
 * Example 1:
 * <p>
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 * Example 2:
 * <p>
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 * Example 3:
 * <p>
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 * Example 4:
 * <p>
 * Input: String="aaacb", Pattern="abc"
 * Output: true
 * Explanation: The string contains "acb" which is a permutation of the given pattern.
 */
public class StringPermutation {

    /**
     * Time Complexity
     * The time complexity of the above algorithm will be O(N + M)
     * where ‘N’ and ‘M’ are the number of characters in the input string and the pattern respectively.
     * <p>
     * Space Complexity
     * The space complexity of the algorithm is O(M) since in the worst case,
     * the whole pattern can have distinct characters which will go into the HashMap.
     */
    public boolean findPermutation(String str, String pattern) {
        if (str == null || pattern == null) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0, count = map.size();
        while (end < str.length()) {
            char endChar = str.charAt(end++);
            if (map.containsKey(endChar) && count >= 0) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    count--;
                }
            }
            while (count == 0) {
                if (end - start == pattern.length()) {
                    return true;
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
        return false;
    }

    boolean findPermutation1(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            var c = str.charAt(windowEnd);

            if (charFrequencyMap.containsKey(c)) {
                charFrequencyMap.put(c, charFrequencyMap.get(c) - 1);
                if (charFrequencyMap.get(c) == 0) {
                    matched++;
                }
            }
            if (matched == charFrequencyMap.size()) {
                return true;
            }

            if (windowEnd >= pattern.length() - 1) {
                final var c1 = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(c1)) {
                    if (charFrequencyMap.get(c1) == 0) {
                        matched--;
                    }
                    charFrequencyMap.put(c1, charFrequencyMap.get(c1) + 1);
                }
            }
        }
        return false;
    }

}
