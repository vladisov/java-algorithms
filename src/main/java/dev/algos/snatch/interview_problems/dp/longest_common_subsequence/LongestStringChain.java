package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    /**
     * Time O(NlogN + NSS)
     * Space O(NS)
     */
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }


    /**
     * Got TLE here
     */
    public int longestStrChainMemo(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        Map<String, Integer> dp = new HashMap<>();
        return longestStrChainRec(words, 0, -1, dp);
    }

    int longestStrChainRec(String[] words, int curr, int prev, Map<String, Integer> dp) {
        if (curr == words.length) {
            return 0;
        }

        String key = curr + "_" + prev;
        if (!dp.containsKey(key)) {
            int len1 = 0;
            if (prev == -1 || isPredecessor(words[prev], words[curr])) {
                len1 = 1 + longestStrChainRec(words, curr + 1, curr, dp);
            }
            int len2 = longestStrChainRec(words, curr + 1, prev, dp);
            dp.put(key, Math.max(len1, len2));
        }

        return dp.get(key);
    }

    boolean isPredecessor(String word, String pred) {
        if (pred.length() - word.length() != 1) {
            return false;
        }
        int i = 0, j = 0, diff = 0;
        while (i < word.length() && j < pred.length()) {
            if (word.charAt(i) != pred.charAt(j)) {
                j++;
                diff++;
            } else {
                i++;
                j++;
            }
            if (diff > 1) {
                return false;
            }
        }
        while (j < pred.length()) {
            diff++;
            j++;
        }

        return diff == 1;
    }
}
