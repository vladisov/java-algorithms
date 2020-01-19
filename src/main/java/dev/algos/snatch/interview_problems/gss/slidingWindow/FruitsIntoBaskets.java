package dev.algos.snatch.interview_problems.gss.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree,
 * you are given two baskets and your goal is to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit.
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class FruitsIntoBaskets {

    int findLength(char[] arr) {
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        int windowStart = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            fruitFrequencyMap.put(arr[i], fruitFrequencyMap.getOrDefault(arr[i], 0) + 1);
            while (fruitFrequencyMap.size() > 2) { //bigger than 2 because we have 2 baskets
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
                if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            max = Math.max(max, i - windowStart + 1);
        }
        return max;
    }
}
