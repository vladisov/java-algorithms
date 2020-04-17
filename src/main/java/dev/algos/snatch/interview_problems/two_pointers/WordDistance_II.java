package dev.algos.snatch.interview_problems.two_pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.
 * <p>
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 */
public class WordDistance_II {
    Map<String, List<Integer>> map;

    public WordDistance_II(String[] words) {
        this.map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            var word = words[i];
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
        }
    }

    /**
     * Time O(N)
     * Space O(N)
     */
    public int shortest(String word1, String word2) {
        List<Integer> indices1 = map.get(word1);
        List<Integer> indices2 = map.get(word2);

        int minLen = Integer.MAX_VALUE;
        int k = 0, m = 0, i, j;
        while (k < indices1.size() && m < indices2.size()) {
            i = indices1.get(k);
            j = indices2.get(m);
            minLen = Math.min(minLen, Math.abs(i - j));
            if (j > i) {
                k++;
            } else {
                m++;
            }
        }
        return minLen;
    }
}
