package dev.algos.snatch.interview_problems.reservoir_sampling;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomPickWithBlacklist {

    private final Random random;
    private final Map<Integer, Integer> map;
    private final int len;

    /**
     * Time O(B)
     */
    public RandomPickWithBlacklist(int n, int[] blacklist) {
        len = n - blacklist.length; // num of available values
        map = new HashMap<>();
        random = new Random();
        Set<Integer> outOfLength = new HashSet<>();
        //all nums that are out of len
        for (int i = len; i < n; i++) {
            outOfLength.add(i); // take all number out of available length
        }
        for (int b : blacklist) outOfLength.remove(b); // remove blacklisted
        var iterator = outOfLength.iterator();
        for (int b : blacklist) {
            if (b < len) { // if it in scope of len -> then we point it out to value out of len
                map.put(b, iterator.next());
            }
        }
    }

    /**
     * Time O(1)
     */
    public int pick() {
        int r = random.nextInt(len);
        return map.getOrDefault(r, r);
    }
}
