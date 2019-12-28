package dev.algos.snatch.interview_problems.array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 */
class LongestSubstringWithSameLettersAfterReplacement {

    int findLength(String str, int k) {
        int windowStart = 0, max = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);
            letterFrequencyMap.put(c, letterFrequencyMap.getOrDefault(c, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(c));

            if (i - windowStart + 1 - maxRepeatLetterCount > k) {
                var charAtStart = str.charAt(windowStart);
                letterFrequencyMap.put(charAtStart, letterFrequencyMap.get(charAtStart) - 1);
                windowStart++;
            }
            max = Math.max(max, i - windowStart + 1);
        }
        return max;
    }
}
