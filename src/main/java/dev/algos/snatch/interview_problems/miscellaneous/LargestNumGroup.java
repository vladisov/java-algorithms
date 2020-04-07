package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class LargestNumGroup {

    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = n; i > 0; i--) {
            int sum = String.valueOf(i)
                    .chars()
                    .map(Character::getNumericValue)
                    .sum();
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(map.get(sum), max);
        }

        int count = 0;
        for (int val : map.values()) {
            if (max == val) {
                count++;
            }
        }
        return count;
    }
}
