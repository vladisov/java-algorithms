package dev.algos.snatch.interview_problems.tree_dfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class BuildTreeFromInfixExpression {

    public static void main(String[] args) {
        BuildTreeFromInfixExpression instance = new BuildTreeFromInfixExpression();
        print(instance.expTree("(1/2/3)"));
    }

    private static void print(Node root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.val);
        print(root.right);
    }

    /**
     * Parser implementation
     * Time O(N)
     * Space O(N)
     * assign by priority -> + -  -> * / -> ()
     */
    public Node expTree(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) queue.add(c);
        return parseExpression(queue);
    }

    private Node parseExpression(Queue<Character> tokens) {
        Node left = parseTerm(tokens);
        while (!tokens.isEmpty() && (tokens.peek() == '+' || tokens.peek() == '-')) {
            char op = tokens.poll();
            Node right = parseTerm(tokens);
            left = new Node(op, left, right);
        }
        return left;
    }

    private Node parseTerm(Queue<Character> tokens) {
        Node left = parseFactor(tokens);
        while (!tokens.isEmpty() && (tokens.peek() == '/' || tokens.peek() == '*')) {
            char op = tokens.poll();
            Node right = parseFactor(tokens);
            left = new Node(op, left, right);
        }
        return left;
    }

    private Node parseFactor(Queue<Character> tokens) {
        Node node = null;
        if (!tokens.isEmpty() && tokens.peek() == '(') {
            tokens.poll();
            node = parseExpression(tokens);
            tokens.poll();
        } else if (!tokens.isEmpty()) {
            node = new Node(tokens.poll());
        }
        return node;
    }

    static class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
