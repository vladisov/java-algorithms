package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class CustomSortString {

    /**
     * Time O(S + T)
     * Space O(T)
     */
    public String customSortString(String S, String T) {
        Integer[] map = new Integer[26];
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        List<Character>[] buckets = new List[S.length()];
        List<Character> toAdd = new ArrayList<>();
        for (int i = 0; i < T.length(); i++) {
            Integer index = map[T.charAt(i) - 'a'];
            if (index != null) {
                if (buckets[index] == null) {
                    buckets[index] = new ArrayList<>();
                }
                buckets[index].add(T.charAt(i));
            } else {
                toAdd.add(T.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    sb.append(c);
                }
            }
        }
        for (char c : toAdd) sb.append(c);
        return sb.toString();
    }

    /**
     * Time and Space O(T)
     */
    public String customSortString1(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) {
            ++count[c - 'a'];
        }  // count each char in T.
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }    // sort chars both in T and S by the order of S.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }    // group chars in T but not in S.
        }
        return sb.toString();
    }

}
