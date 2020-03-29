package dev.algos.snatch.interview_problems.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a list of words, find all the starting indices of substrings in the given string
 * that are a concatenation of all the given words exactly once without any overlapping of words.
 * It is given that all words are of the same length.
 * <p>
 * Example 1:
 * <p>
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 * Example 2:
 * <p>
 * Input: String="catcatfoxfox", Words=["cat", "fox"]
 * Output: [3]
 * Explanation: The only substring containing both the words is "catfox".
 */
public class WordConcatenation {

    /**
     * Time complexity
     * O(n * m * len)
     * Space complexity
     * O(m + n)
     */
    List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<>();
        if (str == null || words.length == 0) return resultIndices;
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        int wordsCount = words.length, wordLength = words[0].length();
        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> seen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!freqMap.containsKey(word)) {
                    break;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                if (seen.get(word) > freqMap.get(word)) {
                    break;
                }
                if (j + 1 == wordsCount) {
                    resultIndices.add(i);
                }
            }
        }
        return resultIndices;
    }
}
