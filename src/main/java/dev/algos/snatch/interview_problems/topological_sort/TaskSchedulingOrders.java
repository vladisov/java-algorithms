package dev.algos.snatch.interview_problems.topological_sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled.
 * Given the number of tasks and a list of prerequisite pairs, write a method to print all possible ordering of tasks meeting all prerequisites.
 * <p>
 * Example 1:
 * <p>
 * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
 * Output: [0, 1, 2]
 * Explanation: There is only possible ordering of the tasks.
 * Example 2:
 * <p>
 * Input: Tasks=4, Prerequisites=[3, 2], [3, 0], [2, 0], [2, 1]
 * Output:
 * 1) [3, 2, 0, 1]
 * 2) [3, 2, 1, 0]
 * Explanation: There are two possible orderings of the tasks meeting all prerequisites.
 */
public class TaskSchedulingOrders {

    private static void printAllTopologicalSorts(HashMap<Integer, List<Integer>> graph,
                                                 HashMap<Integer, Integer> inDegree, Queue<Integer> sources,
                                                 List<Integer> sortedOrder, List<String> result) {
        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = new LinkedList<>(sources);
                // only remove the current source, all other sources should remain in the queue for the next call
                sourcesForNextCall.remove(vertex);
                List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0)
                        sourcesForNextCall.add(child); // save the new source for the next call
                }

                // recursive call to print other orderings from the remaining (and new) sources
                printAllTopologicalSorts(graph, inDegree, sourcesForNextCall, sortedOrder, result);

                // backtrack, remove the vertex from the sorted order and put all of its children back to consider
                // the next source instead of the current vertex
                sortedOrder.remove(vertex);
                for (int child : children)
                    inDegree.put(child, inDegree.get(child) + 1);
            }
        }

        // if sortedOrder doesn't contain all tasks, either we've a cyclic dependency between tasks, or
        // we have not processed all the tasks in this recursive call
        if (sortedOrder.size() == inDegree.size())
            result.add(sortedOrder.toString());
    }

    /**
     * Time O(V! * E)
     * Space O(V! * E)
     */
    public List<String> printOrders(int tasks, int[][] prerequisites) {
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child); // put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }
        Set<Integer> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        allOrdersUtil(graph, visited, inDegree, values, result);
        return result;
    }

    void allOrdersUtil(HashMap<Integer, List<Integer>> graph, Set<Integer> visited,
                       HashMap<Integer, Integer> inDegree, List<Integer> values, List<String> result) {
        boolean flag = false;
        for (int vertex = 0; vertex < graph.size(); vertex++) {
            if (!visited.contains(vertex) && inDegree.get(vertex) == 0) {
                visited.add(vertex);
                values.add(vertex);
                for (int neighbor : graph.get(vertex)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                }
                allOrdersUtil(graph, visited, inDegree, values, result);
                values.remove(values.size() - 1);
                visited.remove(vertex);
                for (int neighbor : graph.get(vertex)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) + 1);
                }
                flag = true;
            }
        }
        if (!flag) {
            result.add(values.toString());
        }
    }

    /**
     * Educative version
     */
    public List<String> printOrdersEducative(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (tasks <= 0)
            return null;

        // a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // b. Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child); // put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        List<String> result = new ArrayList<>();
        printAllTopologicalSorts(graph, inDegree, sources, sortedOrder, result);
        return result;
    }
}

