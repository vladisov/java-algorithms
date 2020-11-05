package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a safe list: 001 010 100 101 111
 * Find a transformation from 000 to 111
 * <p>
 * Contraint: Change one char/bit at a time
 * <p>
 * Length of the String is variable and N < 100000, N being length of String.
 */
public class TransformationPath {

    String findTransformation(int start, int end, Set<Integer> safeSet) {
        if (safeSet.contains(start) || safeSet.contains(end)) return "";
        Map<Integer, List<Integer>> beginMap = new HashMap<>();
        Map<Integer, List<Integer>> endMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        beginMap.put(start, new ArrayList<>());
        beginMap.get(start).add(start);
        endMap.put(end, new ArrayList<>());
        endMap.get(end).add(end);

        while (!endMap.isEmpty() && !beginMap.isEmpty()) {
            if (beginMap.size() > endMap.size()) {
                var tmp = beginMap;
                beginMap = endMap;
                endMap = tmp;
            }
            Map<Integer, List<Integer>> temp = new HashMap<>();
            for (var entry : beginMap.entrySet()) {
                int num = entry.getKey();
                List<Integer> path = entry.getValue();
                for (int neighbor : getNeighbors(num, end)) {
                    if (safeSet.contains(neighbor)) continue;
                    List<Integer> combinedPath = new ArrayList<>(path);
                    if (endMap.containsKey(neighbor)) {
                        List<Integer> endPath = endMap.get(neighbor);
                        Collections.reverse(endPath);
                        combinedPath.addAll(endPath);
                        return pathToString(combinedPath, start);
                    }
                    if (!visited.contains(neighbor)) {
                        combinedPath.add(neighbor);
                        temp.put(neighbor, combinedPath);
                        visited.add(neighbor);
                    }
                }
            }
            beginMap = temp;
        }
        return "";
    }

    private String pathToString(List<Integer> path, int start) {
        if (!path.isEmpty()) {
            if (path.get(0) != start) {
                Collections.reverse(path);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(Integer.toBinaryString(path.get(i)));
                if (i != path.size() - 1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
        return "";
    }

    List<Integer> getNeighbors(int num, int target) {
        int x = 1;
        List<Integer> list = new ArrayList<>();
        while (x <= target) {
            list.add(num ^ x);
            x <<= 1;
        }
        return list;
    }

}
