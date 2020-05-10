package dev.algos.snatch.interview_problems.top_k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.
 * <p>
 * The comparison of strings is case-insensitive.
 * Multiple occurances of a keyword in a review should be considred as a single mention.
 * If keywords are mentioned an equal number of times in reviews, sort alphabetically.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * k = 2
 * keywords = ["anacell", "cetracular", "betacellular"]
 * reviews = [
 * "Anacell provides the best services in the city",
 * "betacellular has awesome services",
 * "Best services provided by anacell, everyone should use anacell",
 * ]
 * <p>
 * Output:
 * ["anacell", "betacellular"]
 * <p>
 * Explanation:
 * "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
 */
public class FindKeywords {

    public static void main(String[] args) {
        System.out.println(findKeywords(List.of("anacell", "cetracular", "betacellular"), List.of("Anacell provides the best services in the city",
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell"), 2).toString());

        System.out.println(findKeywords(List.of("anacell", "betacellular", "cetracular", "deltacellular", "eurocell"), List.of("I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular."), 2).toString());
    }

    /**
     * keywords length - N
     * reviews length = M
     * review = R
     * int K
     * <p>
     * Time complexity O(M*R + N*M + NlogK)
     * Space complexity O(N)
     */
    static List<String> findKeywords(List<String> keywords, List<String> reviews, int k) {
        if (keywords.isEmpty() || reviews.isEmpty() || k == 0) return List.of();
        List<Set<String>> reviewsList = preprocess(reviews);
        Map<String, Integer> freq = new HashMap<>();
        for (String keyword : keywords) {
            for (var set : reviewsList) {
                if (set.contains(keyword.toLowerCase())) {
                    freq.put(keyword, freq.getOrDefault(keyword, 0) + 1);
                }
            }
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return b.compareTo(a);
            }
            return freq.get(a) - freq.get(b);
        });

        for (var keyword : keywords) {
            if (!freq.containsKey(keyword)) continue;
            minHeap.add(keyword);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }

    static List<Set<String>> preprocess(List<String> reviews) {
        List<Set<String>> list = new ArrayList<>();
        for (String review : reviews) {
            String format = review.replaceAll("[^a-zA-Z]", " ");
            String[] split = format.split("\\s+");
            Set<String> set = new HashSet<>();
            for (String word : split) {
                set.add(word.toLowerCase());
            }
            list.add(set);
        }
        return list;
    }
}
