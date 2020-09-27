package dev.algos.snatch.interview_problems.minimum_spanning_tree;

import java.util.ArrayList;
import java.util.List;

public class MinCostToConnectPoints {

    /**
     * Time O(N^2logN^2 + N^2logN^2)
     * Space O(N^2)
     */
    public int minCostConnectPoints(int[][] points) {
        UnionFind uf = new UnionFind(points.length);
        int distance = 0;
        List<Edge> edges = buildEdges(points);
        for (var edge : edges) {
            int src = edge.src;
            int dst = edge.dst;
            int weight = edge.weight;
            if (uf.connect(edge.src, edge.dst)) {
                distance += weight;
            }
        }
        return distance;
    }


    private List<Edge> buildEdges(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j, getDistance(points[i], points[j])));
            }
        }
        edges.sort((a, b) -> a.weight - b.weight);
        return edges;
    }


    int getDistance(int[] pointA, int[] pointB) {
        int x1 = pointA[0];
        int x2 = pointB[0];
        int y1 = pointA[1];
        int y2 = pointB[1];
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static class Edge {
        int src;
        int dst;
        int weight;

        public Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    static class UnionFind {
        int[] arr;
        int[] size;

        public UnionFind(int n) {
            arr = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
                size[i] = 1;
            }
        }

        public int root(int i) {
            while (i != arr[i]) {
                arr[i] = arr[arr[i]];
                i = arr[i];
            }
            return i;
        }

        boolean hasConnection(int i) {
            return root(i) != i;
        }


        public boolean connect(int i, int j) {
            int p = root(i);
            int q = root(j);
            if (p == q) return false;

            if (size[p] < size[q]) {
                arr[p] = arr[q];
                size[q] += size[p];
            } else {
                arr[q] = arr[p];
                size[p] += size[q];
            }
            return true;
        }
    }
}
