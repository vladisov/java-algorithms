package dev.algos.snatch.interview_problems.gss.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern,
 * find the smallest substring in the given string which has all the characters of the given pattern.
 *
 * Time Complexity:  O(N + M)O(N+M) where ‘N’ and ‘M’ are the number of characters in the input string and the pattern
 * Space Complexity: O(M) since in the worst case,
 *                   the whole pattern can have distinct characters which will go into the HashMap.
 *                   In the worst case, we also need O(N)O(N) space for the resulting substring,
 *                   which will happen when the input string is a permutation of the pattern.
 */
class SmallestWindowContainingSubstring {

    String findSubstring(String str, String pattern) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        int windowStart = 0;
        int matched = 0;
        int minLength = str.length() + 1;
        int strStart = 0;

        for (char c : pattern.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            final var item = str.charAt(windowEnd);

            if (charFrequencyMap.containsKey(item)) {
                charFrequencyMap.put(item, charFrequencyMap.get(item) - 1);
                if (charFrequencyMap.get(item) >= 0) {
                    matched++;
                }
            }

            while (matched == pattern.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    strStart = windowStart;
                }
                final var c = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(c)) {
                    if (charFrequencyMap.get(c) == 0) {
                        matched--;
                    }
                    charFrequencyMap.put(c, charFrequencyMap.get(c) + 1);
                }
            }
        }
        return minLength > str.length() ? "" : str.substring(strStart, strStart + minLength);
    }
}
