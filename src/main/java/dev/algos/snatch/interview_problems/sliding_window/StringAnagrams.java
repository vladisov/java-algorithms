package dev.algos.snatch.interview_problems.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 * <p>
 * Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
 * <p>
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 * <p>
 * Example 1:
 * <p>
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 * Example 2:
 * <p>
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
public class StringAnagrams {

    /**
     * Time Complexity
     * The time complexity of the above algorithm will be O(N + M) where ‘N’ and ‘M’
     * are the number of characters in the input string and the pattern respectively.
     * <p>
     * Space Complexity
     * The space complexity of the algorithm is O(M) since in the worst case,
     * the whole pattern can have distinct characters which will go into the HashMap.
     * In the worst case, we also need O(N) space for the result list,
     * this will happen when the pattern has only one character and the string contains only that character.
     */
    List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        if (str == null || pattern == null) return resultIndices;

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
                    resultIndices.add(start);
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
        return resultIndices;
    }

    List<Integer> findStringAnagrams1(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (char c : pattern.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            final var c = str.charAt(windowEnd);

            if (charFrequencyMap.containsKey(c)) {
                charFrequencyMap.put(c, charFrequencyMap.get(c) - 1);
                if (charFrequencyMap.get(c) == 0) {
                    matched++;
                }
            }

            if (matched == charFrequencyMap.size()) {
                resultIndices.add(windowStart);
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
        return resultIndices;
    }
}
