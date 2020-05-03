package dev.algos.snatch.interview_problems.dp;

import java.util.List;

public class NumberOfWaysToWearDifferentHats {

    int MOD = 1000000007;
    int count = 0;

    public int numberWays(List<List<Integer>> hats) {
        boolean[] visited = new boolean[41];
        backtrack(hats, 0, visited);
        return count;
    }

    void backtrack(List<List<Integer>> hats, int index, boolean[] visited) {
        if (index == hats.size()) {
            count = (count + 1) % MOD;
        } else {
            List<Integer> prefHats = hats.get(index);
            for (Integer prefHat : prefHats) {
                if (visited[prefHat]) continue;
                visited[prefHat] = true;
                backtrack(hats, index + 1, visited);
                visited[prefHat] = false;
            }
        }
    }
}
