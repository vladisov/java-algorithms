package dev.algos.snatch.interview_problems.hash_table;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
 * <p>
 * Example :
 * Input:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 */
public class NumberOfMatchingSubsequences {

    /**
     * Time O(S + L * W) ?? //TODO
     * Space(W)
     */
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<>());
        }
        for (String word : words) {
            map.get(word.charAt(0)).add(word);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            Queue<String> wordsQueue = map.get(c);
            int n = wordsQueue.size();
            for (int i = 0; i < n; i++) {
                String word = wordsQueue.poll();
                if (word.length() == 1) {
                    count++;
                } else {
                    String remaining = word.substring(1);
                    map.get(remaining.charAt(0)).add(remaining);
                }
            }
        }
        return count;
    }
}
