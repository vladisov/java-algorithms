package dev.algos.snatch.interview_problems.dp;

import java.util.LinkedList;
import java.util.List;

public class JumpGame_III {

    public boolean canReach(int[] arr, int start) {
        Boolean[] visited = new Boolean[arr.length];
        List<Integer> path = new LinkedList<>();
        return dfs(arr, start, path, visited);
    }

    private boolean dfs(int[] arr, int index, List<Integer> path, Boolean[] visited) {
        if (index >= arr.length || index < 0) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }
        if (visited[index] != null) {
            return visited[index];
        }
        path.add(index);

        int nextLeft = index - arr[index];
        int nextRight = index + arr[index];
        boolean left = false;
        boolean right = false;
        if (!path.contains(nextLeft)) {
            left = dfs(arr, nextLeft, path, visited);
        }
        if (!path.contains(nextRight)) {
            right = dfs(arr, nextRight, path, visited);
        }
        if (left == true || right == true) {
            return true;
        }
        path.remove(path.size() - 1);
        visited[index] = false;
        return visited[index];
    }
}
