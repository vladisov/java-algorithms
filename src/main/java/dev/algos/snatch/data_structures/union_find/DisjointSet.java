package dev.algos.snatch.data_structures.union_find;

import java.util.HashMap;
import java.util.Map;

/**
 * Disjoint sets using path compression and union by rank
 * Supports 3 operations
 * 1) makeSet
 * 2) union
 * 3) findSet
 * <p>
 * For m operations and total n elements time complexity is O(m*f(n)) where f(n) is
 * very slowly growing function. For most cases f(n) <= 4 so
 * total time will be O(m). Proof in Coreman book.
 **/
public class DisjointSet {

    Map<Integer, Node> map = new HashMap<>();

    public int findSet(int id) {
        return findSet(map.get(id)).data;
    }

    /*
     does path compression
     */
    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return node;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public void makeSet(int id) {
        Node node = new Node(id);
        map.put(id, node);
    }

    /**
     * Combines two sets together to one.
     * Does union by rank
     */
    public boolean union(int i, int j) {
        Node p = findSet(map.get(i));
        Node q = findSet(map.get(j));
        if (p == q) return false;
        //else whoever's rank is higher becomes parent of other
        if (p.rank < q.rank) {
            p.parent = q;
        } else {
            //increment rank only if both sets have same rank
            q.parent = p;
            p.rank = (p.rank == q.rank) ? p.rank + 1 : p.rank;
        }
        return true;
    }

    static class Node {
        int data;
        int rank;
        Node parent;

        public Node(int data) {
            this.data = data;
            this.parent = this;
        }
    }
}
