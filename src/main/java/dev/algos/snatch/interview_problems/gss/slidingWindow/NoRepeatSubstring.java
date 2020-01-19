package dev.algos.snatch.interview_problems.gss.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring which has no repeating characters.
 */
class NoRepeatSubstring {

    int findLength(String str) {
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
