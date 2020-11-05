package dev.algos.snatch.interview_problems.trie;

public class MagicDictionary {
    private final Trie trie;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        trie = new Trie();
    }

    /**
     * Time O(n * m)
     */
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            trie.addWord(word);
        }
    }


    /**
     * Time O(26 * m)
     */
    public boolean search(String word) {
        return trie.isInTrie(word);
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            if (word == null || word.length() == 0) return;

            var curr = root;
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                if (curr.children[charIndex] == null) {
                    curr.children[charIndex] = new TrieNode();
                }
                curr = curr.children[charIndex];
            }
            curr.endWord = true;
        }

        public boolean isInTrie(String word) {
            return isInTrie(word, root, 0, false);
        }

        private boolean isInTrie(String word, TrieNode node, int i, boolean skip) {
            if (i == word.length()) {
                return skip && node.endWord;
            }
            int charIndex = word.charAt(i) - 'a';
            if (skip) {
                TrieNode child = node.children[charIndex];
                if (child == null) return false;
                return isInTrie(word, child, i + 1, skip);
            }
            for (int j = 0; j < 26; j++) {
                TrieNode child = node.children[j];
                if (child != null) {
                    if (j == charIndex) {
                        if (isInTrie(word, child, i + 1, false)) {
                            return true;
                        }
                    } else {
                        if (isInTrie(word, child, i + 1, true)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    static class TrieNode {
        TrieNode[] children;
        boolean endWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            endWord = false;
        }
    }
}
