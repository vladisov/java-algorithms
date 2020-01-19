package dev.algos.snatch.interview_problems.gss.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * <p>
 * Time complexity: O(N+M) where ‘N’ and ‘M’ are the number of characters in the input string and the pattern
 * Space complexity: O(M) since in the worst case, the whole pattern can have distinct characters which will go into the HashMap
 */
class PermutationInString {

    boolean findPermutation(String str, String pattern) {
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
