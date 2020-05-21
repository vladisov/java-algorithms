package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GraphShortestDistances {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        List<Graph> graphs = new ArrayList<>();
        List<Integer> roots = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int inputs = scanner.nextInt();
        while (scanner.hasNext()) {
            int size = scanner.nextInt();
            int edges = scanner.nextInt();
            Graph graph = new Graph(size);
            for (int i = 0; i < edges; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                graph.addEdge(a, b);
            }
            int root = scanner.nextInt();
            roots.add(root);
            graphs.add(graph);
        }
        scanner.close();

        for (int i = 0; i < inputs; i++) {
            Graph graph = graphs.get(i);
            System.out.println(graph.printAllDistances(roots.get(i)));
        }
    }

    static class Graph {
        int size;
        List[] nodes;
        int weight = 6;

        public Graph(int size) {

            this.size = size + 1;
            this.nodes = new List[this.size + 1];
        }


        public void addEdge(int a, int b) {
            if (nodes[a] == null) {
                nodes[a] = new ArrayList<>();
            }
            nodes[a].add(b);
            if (nodes[b] == null) {
                nodes[b] = new ArrayList<>();
            }
            nodes[b].add(a);
        }

        String printAllDistances(int root) {
            if (root >= size) return "";

            int[] distance = new int[size];

            Arrays.fill(distance, -1);
            distance[root] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                int distSoFar = distance[node];
                List<Integer> neighbors = nodes[node];
                if (neighbors != null) {
                    for (int nei : neighbors) {
                        if (distance[nei] == -1) {
                            distance[nei] = distSoFar + weight;
                            queue.add(nei);
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < distance.length; i++) {
                if (distance[i] != 0) {
                    sb.append(distance[i]).append(" ");
                }
            }
            return sb.toString();
        }
    }
}
