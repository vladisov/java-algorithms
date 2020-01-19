package dev.algos.snatch.interview_problems.gss.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(k)
 */
class LongestSubstringKDistinct {

    int findLength(String str, int k) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        int windowStart = 0;
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
            while (charFrequencyMap.size() > k) {
                final char left = str.charAt(windowStart);
                charFrequencyMap.put(left, charFrequencyMap.get(left) - 1);
                if (charFrequencyMap.get(left) == 0) {
                    charFrequencyMap.remove(left);
                }
                windowStart++;
            }
            max = Math.max(max, i - windowStart + 1);
        }
        return max;
    }
}
