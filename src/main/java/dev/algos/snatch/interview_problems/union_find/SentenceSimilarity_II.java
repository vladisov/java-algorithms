package dev.algos.snatch.interview_problems.union_find;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
 * <p>
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 * <p>
 * Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.
 * <p>
 * Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 * <p>
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
 * <p>
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 */
public class SentenceSimilarity_II {

    /**
     * Time O(NlogP + P)
     * Space O(P)
     */
    boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        UnionFind uf = new UnionFind(pairs.size() * 2);
        Map<String, Integer> wordToId = new HashMap<>();
        int id = 0;
        for (var pair : pairs) {
            for (String word : pair) {
                if (!wordToId.containsKey(word)) {
                    wordToId.put(word, id++);
                }
            }
        }
        for (var pair : pairs) {
            int i = wordToId.get(pair.get(0));
            int j = wordToId.get(pair.get(1));
            uf.union(i, j);
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])) {
                Integer id1 = wordToId.get(words1[i]);
                Integer id2 = wordToId.get(words2[i]);
                if (id1 == null || id2 == null || uf.root(id1) != uf.root(id2)) {
                    return false;
                }
            }
        }


        return false;
    }


    static class UnionFind {
        int[] arr;

        public UnionFind(int n) {
            arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        int root(int i) {
            while (i != arr[i]) {
                arr[i] = arr[arr[i]];
                i = arr[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p = root(i);
            int q = root(j);
            arr[p] = q;
        }
    }
}
