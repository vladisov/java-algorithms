package dev.algos.snatch.interview_problems.tree_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * For example, you may serialize the following 3-ary tree
 * <p>
 * <p>
 * <p>
 * as [1 [3[5 6] 2 4]]. Note that this is just an example, you do not necessarily need to follow this format.
 * <p>
 * Or you can follow LeetCode's level order traversal serialization format, where each group of children is separated by the null value.
 * <p>
 * <p>
 * <p>
 * For example, the above tree may be serialized as [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14].
 * <p>
 * You do not necessarily need to follow the above suggested formats, there are many more different formats that work so please be creative and come up with different approaches yourself.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 * Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 */
public class SerializeDeserializeNaryTree {

    /**
     * Time O(N)
     * Space O(N)
     */
    public String serialize(Node root) {
        if (root == null) {
            return "X";
        }
        StringBuilder sb = new StringBuilder();
        if (root.children != null) {
            for (Node child : root.children) {
                sb.append(serialize(child));
            }
        }
        String size = root.children == null ? "0" : root.children.size() + "";
        return root.val + "_" + size + "," + sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] split = data.split(",");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, split);
        Node node = helper(queue);
        return node;
    }

    private Node helper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String val = queue.poll();
        if (val.equals("X")) return null;
        String[] split = val.split("_");
        int size = Integer.parseInt(split[1]);
        int value = Integer.parseInt(split[0]);
        Node node = new Node(value, new ArrayList<>());
        for (int i = 0; i < size; i++) {
            node.children.add(helper(queue));
        }

        return node;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

}
