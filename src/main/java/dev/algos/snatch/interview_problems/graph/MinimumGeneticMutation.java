package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumGeneticMutation {

    /**
     * M - len of word, N - len of bank
     * Time O(N * M^2)
     * Space O(N * M^2)
     */
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);
        if (start.equals(end)) return 0;
        if (!bankSet.contains(end)) return -1;
        Set<String> beginSet = new HashSet<>() {{
            add(start);
        }};
        Set<String> endSet = new HashSet<>() {{
            add(end);
        }};
        Set<String> visited = new HashSet<>();
        visited.add(start);
        visited.add(end);
        int lvl = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> tmp = new HashSet<>();
            for (String node : beginSet) {
                for (String adj : getAdjacentNodes(node)) {
                    if (endSet.contains(adj)) {
                        return lvl;
                    }
                    if (bankSet.contains(adj) && !visited.contains(adj)) {
                        tmp.add(adj);
                        visited.add(adj);
                    }
                }
            }
            lvl++;
            beginSet = tmp;
        }
        return -1;
    }


    /**
     * Time O(N^2)
     */
    private List<String> getAdjacentNodes(String node) {
        List<String> nodes = new ArrayList<>();
        char[] letters = {'A', 'C', 'G', 'T'};
        char[] chars = node.toCharArray();
        for (int j = 0; j < node.length(); j++) {
            char old = chars[j];
            for (char c : letters) {
                if (c != old) {
                    chars[j] = c;
                    nodes.add(new String(chars));
                }
            }
            chars[j] = old;
        }
        return nodes;
    }
}
