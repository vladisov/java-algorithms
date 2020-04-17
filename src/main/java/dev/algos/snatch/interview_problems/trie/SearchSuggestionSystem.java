package dev.algos.snatch.interview_problems.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 * <p>
 * Return list of lists of the suggested products after each character of searchWord is typed.
 */
public class SearchSuggestionSystem {

    /**
     * Time O(P * L + P * S * L log L) P - products length, L - length of word, S - length of searchword ??
     * Space O(P * L * W) where W - words on each level might be =  P
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.addWord(product);
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            result.add(trie.getAllByPrefix(prefix));
        }
        return result;
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        void addWord(String word) {
            if (word == null || word.length() == 0) return;

            var curr = root;
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                if (curr.children[charIndex] == null) {
                    curr.children[charIndex] = new TrieNode();
                }
                curr = curr.children[charIndex];
                curr.addWord(word);
            }
            curr.endWord = true;
        }

        List<String> getAllByPrefix(String word) {
            List<String> result = new ArrayList<>();
            var curr = root;
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                if (curr.children[charIndex] == null) {
                    return result;
                }
                curr = curr.children[charIndex];
            }
            List<String> words = curr.getWords();
            result = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                if (i < words.size()) {
                    result.add(words.get(i));
                }
            }
            return result;
        }
    }

    static class TrieNode {
        TrieNode[] children;
        boolean endWord;
        private List<String> words;

        public TrieNode() {
            this.children = new TrieNode[26];
            endWord = false;
            this.words = new ArrayList<>();
        }

        void addWord(String word) {
            words.add(word);
        }

        public List<String> getWords() {
            Collections.sort(words);
            return words;
        }
    }
}
