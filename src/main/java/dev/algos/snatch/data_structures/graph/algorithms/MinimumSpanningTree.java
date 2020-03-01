package dev.algos.snatch.data_structures.graph.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Vertex {
    private int id;
    private boolean visited;

    Vertex(int id, boolean visited) {
        super();
        this.id = id;
        this.visited = visited;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    boolean isVisited() {
        return visited;
    }

    void setVisited(boolean visited) {
        this.visited = visited;
    }
}

class Edge {
    private int weight;
    private boolean visited;
    private Vertex src;
    private Vertex dest;

    Edge(int weight, boolean visited, Vertex src,
         Vertex dest) {
        this.weight = weight;
        this.visited = visited;
        this.src = src;
        this.dest = dest;
    }

    int getWeight() {
        return weight;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    boolean isVisited() {
        return visited;
    }

    void setVisited(boolean visited) {
        this.visited = visited;
    }

    Vertex getSrc() {
        return src;
    }

    void setSrc(Vertex src) {
        this.src = src;
    }

    Vertex getDest() {
        return dest;
    }

    void setDest(Vertex dest) {
        this.dest = dest;
    }
}

class Graph {
    private List<Vertex> vertices;   //vertices
    private List<Edge> edges;     //edges

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        super();
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    // This method returns the Vertex with a given id if it
    // already exists in the graph, returns NULL otherwise
    Vertex isVertexExists(int id) {
        for (Vertex vertex : vertices) {
            if (vertex.getId() == id) {
                return vertex;
            }
        }
        return null;
    }

    // This method generates the graph with v vertices
    // and edges edges
    void generateGraph(int vertices, List<ArrayList<Integer>> edges) {
        // create vertices
        for (int i = 0; i < vertices; i++) {
            Vertex v = new Vertex(i + 1, false);
            this.vertices.add(v);
        }

        // create edges
        for (ArrayList<Integer> edge : edges) {
            Vertex src = isVertexExists(edge.get(1));
            Vertex dest = isVertexExists(edge.get(2));
            Edge e = new Edge(edge.get(0), false, src, dest);
            getEdges().add(e);
        }
    }

    // This method finds the MST of a graph using
    // Prim's Algorithm
    // returns the weight of the MST
    int findMinSpanningTree() {
        int vertex_count = 0;
        int weight = 0;

        // Add first Vertex to the MST
        Vertex current = vertices.get(0);
        current.setVisited(true);
        vertex_count++;

        // Construct the remaining MST using the
        // smallest weight Edge
        while (vertex_count < vertices.size()) {
            Edge smallest = null;
            for (int i = 0; i < edges.size(); i++) {
                if (!edges.get(i).isVisited() && !edges.get(i).getDest().isVisited()) {
                    smallest = edges.get(i);
                    break;
                }
            }

            for (int i = 0; i < edges.size(); i++) {
                if (!edges.get(i).isVisited()) {
                    if (edges.get(i).getSrc().isVisited()
                            && !edges.get(i).getDest().isVisited()
                            && (edges.get(i).getWeight() < smallest.getWeight())) {
                        smallest = edges.get(i);
                    }
                }
            }

            smallest.setVisited(true);
            smallest.getDest().setVisited(true);
            weight += smallest.getWeight();
            vertex_count++;
        }
        return weight;
    }

    void printGraph() {
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println(
                    vertices.get(i).getId() + " " + vertices.get(i).isVisited());
        }
        System.out.println();
        for (int i = 0; i < edges.size(); i++) {
            System.out.println(edges.get(i).getSrc().getId() + "->"
                    + edges.get(i).getDest().getId() + "["
                    + edges.get(i).getWeight() + ", "
                    + edges.get(i).isVisited() + "]  ");
        }
        System.out.println("\n");
    }

    void printMst(int w) {
        System.out.println("MST");
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).isVisited() == true) {
                System.out.println(edges.get(i).getSrc().getId() + "->"
                        + edges.get(i).getDest().getId());
            }
        }
        System.out.println("weight: " + w);
        System.out.println();
    }
}

class Mst {
    public static void test_graph1() {
        Graph g = new Graph(new ArrayList<Vertex>(),
                new ArrayList<Edge>());
        int v = 5;

        // each Edge contains the following: weight, src, dest
        ArrayList<Integer> e1 = new ArrayList<Integer>(
                Arrays.asList(1, 1, 2));
        ArrayList<Integer> e2 = new ArrayList<Integer>(
                Arrays.asList(1, 1, 3));
        ArrayList<Integer> e3 = new ArrayList<Integer>(
                Arrays.asList(2, 2, 3));
        ArrayList<Integer> e4 = new ArrayList<Integer>(
                Arrays.asList(3, 2, 4));
        ArrayList<Integer> e5 = new ArrayList<Integer>(
                Arrays.asList(3, 3, 5));
        ArrayList<Integer> e6 = new ArrayList<Integer>(
                Arrays.asList(2, 4, 5));

        List<ArrayList<Integer>> e = new ArrayList<ArrayList<Integer>>();
        e.add(e1);
        e.add(e2);
        e.add(e3);
        e.add(e4);
        e.add(e5);
        e.add(e6);
        String s = "123";
        s.contains('1' + "");

        g.generateGraph(v, e);
        System.out.println("Testing graph 1...");
        // vertices.printGraph();
        int w = g.findMinSpanningTree();
        g.printMst(w);
    }

    public static void test_graph2() {
        Graph g = new Graph(new ArrayList<Vertex>(),
                new ArrayList<Edge>());
        int v = 7;

        // each Edge contains the following: weight, src, dest
        ArrayList<Integer> e1 = new ArrayList<Integer>(
                Arrays.asList(2, 1, 4));
        ArrayList<Integer> e2 = new ArrayList<Integer>(
                Arrays.asList(1, 1, 3));
        ArrayList<Integer> e3 = new ArrayList<Integer>(
                Arrays.asList(2, 1, 2));
        ArrayList<Integer> e4 = new ArrayList<Integer>(
                Arrays.asList(1, 3, 4));
        ArrayList<Integer> e5 = new ArrayList<Integer>(
                Arrays.asList(3, 2, 4));
        ArrayList<Integer> e6 = new ArrayList<Integer>(
                Arrays.asList(2, 3, 5));
        ArrayList<Integer> e7 = new ArrayList<Integer>(
                Arrays.asList(2, 4, 7));
        ArrayList<Integer> e8 = new ArrayList<Integer>(
                Arrays.asList(1, 5, 6));
        ArrayList<Integer> e9 = new ArrayList<Integer>(
                Arrays.asList(2, 5, 7));

        List<ArrayList<Integer>> e = new ArrayList<ArrayList<Integer>>();
        e.add(e1);
        e.add(e2);
        e.add(e3);
        e.add(e4);
        e.add(e5);
        e.add(e6);
        e.add(e7);
        e.add(e8);
        e.add(e9);

        g.generateGraph(v, e);
        System.out.println("Testing graph 2...");
        // vertices.printGraph();
        int w = g.findMinSpanningTree();
        g.printMst(w);
    }

    public static void main(String[] args) {
        test_graph1();
        test_graph2();

        System.out.println("Completed!");
    }
}
