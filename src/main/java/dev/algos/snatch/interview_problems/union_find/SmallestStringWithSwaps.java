package dev.algos.snatch.interview_problems.union_find;

import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 * <p>
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 * <p>
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * Example 2:
 * <p>
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * Example 3:
 * <p>
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 */
public class SmallestStringWithSwaps {

    /**
     * Time O(NlogN)
     * Space O(N)
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        PriorityQueue<Integer>[] list = new PriorityQueue[s.length()];
        UnionFind uf = new UnionFind(s.length());
        for (var pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        for (int i = 0; i < s.length(); i++) {
            int root = uf.root(i);
            if (list[root] == null) {
                list[root] = new PriorityQueue<Integer>((a, b) -> s.charAt(a) - s.charAt(b));
            }
            //add to root's children
            list[root].add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //find root and it's possible children
            sb.append(s.charAt(list[uf.root(i)].poll()));
        }
        return sb.toString();
    }

    static class UnionFind {
        int[] arr;
        int[] size;

        public UnionFind(int n) {
            arr = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
                size[i] = 1;
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
            if (size[p] > size[q]) {
                arr[p] = arr[q];
                size[q] += size[p];
            } else {
                arr[q] = arr[p];
                size[p] += size[q];
            }
        }
    }
}
