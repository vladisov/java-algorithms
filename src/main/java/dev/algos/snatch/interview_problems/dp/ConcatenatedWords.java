package dev.algos.snatch.interview_problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 * <p>
 * Example:
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * <p>
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * <p>
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 */
public class ConcatenatedWords {

    /**
     * Time O(N*L^3)
     * Space O(N+L)
     */
    List<String> findWords(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (isConcatenated(set, word)) {
                result.add(word);
            }
            set.add(word);
        }
        return result;
    }

    boolean isConcatenated(Set<String> wordDict, String word) {
        if (word.isEmpty()) {
            return false;
        }
        if (wordDict.contains(word)) {
            return true;
        }
        for (int i = 1; i < word.length(); i++) {
            String first = word.substring(0, i);
            String last = word.substring(i);
            if (wordDict.contains(first) && isConcatenated(wordDict, last)) {
                return true;
            }
        }
        return false;
    }
}
