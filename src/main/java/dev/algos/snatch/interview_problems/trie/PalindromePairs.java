package dev.algos.snatch.interview_problems.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 * <p>
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 */
public class PalindromePairs {

    //TODO trie approach

    /**
     * Time complexity O(N*K^2)
     * Space O(N+K)^2
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i); //index for lookup
        }
        List<List<Integer>> result = new ArrayList<>();
        for (String word : map.keySet()) {
            int currentIndex = map.get(word);
            String reversed = new StringBuilder(word).reverse().toString();

            //reversed case
            if (map.containsKey(reversed) && map.get(reversed) != currentIndex) {
                result.add(List.of(map.get(reversed), currentIndex));
            }

            //word is word1 case
            for (String prefix : allValidPrefixes(word)) {
                String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                if (map.containsKey(reversedPrefix)) {
                    result.add(List.of(map.get(reversedPrefix), currentIndex));
                }
            }

            //word is word2 case
            for (String suffix : allValidSuffixes(word)) {
                String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                if (map.containsKey(reversedSuffix)) {
                    result.add(List.of(map.get(reversedSuffix), currentIndex));
                }
            }
        }
        return result;
    }

    private List<String> allValidPrefixes(String word) {
        List<String> validPrefixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, i, word.length() - 1)) {
                validPrefixes.add(word.substring(0, i));
            }
        }
        return validPrefixes;
    }

    private List<String> allValidSuffixes(String word) {
        List<String> validSuffixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, 0, i)) {
                validSuffixes.add(word.substring(i + 1));
            }
        }
        return validSuffixes;
    }

    boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
