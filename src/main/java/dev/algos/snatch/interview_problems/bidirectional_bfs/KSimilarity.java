package dev.algos.snatch.interview_problems.bidirectional_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KSimilarity {

    public int kSimilarity(String a, String b) {
        if (a.equals(b)) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(a);
        int k = 0;
        visited.add(a);
        while (!queue.isEmpty()) {
            k++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                Set<String> neighbors = getNeighbors(node, b);
                for (var nei : neighbors) {
                    if (nei.equals(b)) {
                        return k;
                    }
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        queue.add(nei);
                    }
                }
            }
        }
        return k;
    }

    Set<String> getNeighbors(String a, String b) {
        Set<String> set = new HashSet<>();
        char[] arr = a.toCharArray();
        int i = 0;
        for (; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) break;
        }
        for (int j = i + 1; j < a.length(); j++) {
            if (a.charAt(j) == b.charAt(i)) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                String s = new String(arr);
                set.add(s);

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        return set;
    }
}
