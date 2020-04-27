package dev.algos.snatch.interview_problems.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * Example 2:
 * <p>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class WordBreak_II {

    /**
     * (1) each level we can at most have m choices
     * (2) each level, we have to do string concat which will cost n
     * (3) at most we will have height of (s / n)
     * based on that, total time complexity will be o(mn)^(s / n)
     * <p>
     * Space
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.isEmpty()) return List.of();

        return wordBreakRec(s, wordDict, new HashMap<>());
    }

    private List<String> wordBreakRec(String s, List<String> wordDic, Map<String, LinkedList<String>> dp) {
        if (dp.containsKey(s)) {
            return dp.get(s);
        }

        if (s.length() == 0) {
            return List.of();
        }

        LinkedList<String> result = new LinkedList<>();
        for (String word : wordDic) {
            if (s.startsWith(word)) {
                String sub = s.substring(word.length());
                if (s.length() == word.length()) {
                    result.add(word);
                    continue;
                }
                List<String> subList = wordBreakRec(sub, wordDic, dp);
                for (String str : subList) {
                    result.add(word + " " + str);
                }
            }
        }
        dp.put(s, result);
        return result;
    }
}
