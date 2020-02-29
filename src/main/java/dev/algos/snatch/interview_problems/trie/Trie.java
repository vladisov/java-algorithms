package dev.algos.snatch.interview_problems.trie;

/**
 * Design a Trie
 */
class Trie {
    TreeNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TreeNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        char[] chs = word.toCharArray();
        TreeNode curr = root;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TreeNode();
            }
            curr = curr.children[index];
        }
        curr.endWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        char[] chs = word.toCharArray();
        TreeNode curr = root;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            curr = curr.children[index];
            if (curr == null) {
                return false;
            }
        }
        return curr.endWord;
    }

    /**
     * Returns if there is any prefix in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        char[] chs = prefix.toCharArray();
        TreeNode curr = root;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            curr = curr.children[index];
            if (curr == null) {
                return false;
            }
        }
        return curr != null;
    }

    static class TreeNode {
        TreeNode[] children;
        boolean endWord;

        TreeNode() {
            children = new TreeNode[26];
            endWord = false;
        }
    }
}
