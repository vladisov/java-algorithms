package dev.algos.snatch.interview_problems.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) return List.of();
        Map<String, Queue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).add(to);
        }
        LinkedList<String> path = new LinkedList<>();
        dfs("JFK", path, map);
        return path;
    }

    private void dfs(String root, LinkedList<String> path, Map<String, Queue<String>> map) {
        Queue<String> queue = map.get(root);
        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll(), path, map);
        }
        path.addFirst(root);
    }
}
