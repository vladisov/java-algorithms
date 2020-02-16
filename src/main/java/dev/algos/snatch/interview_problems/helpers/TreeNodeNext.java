package dev.algos.snatch.interview_problems.helpers;

public class TreeNodeNext {
    public int val;
    public TreeNodeNext left;
    public TreeNodeNext right;
    public TreeNodeNext next;

    public TreeNodeNext() {
    }

    public TreeNodeNext(int _val) {
        val = _val;
    }

    public TreeNodeNext(int _val, TreeNodeNext _left, TreeNodeNext _right, TreeNodeNext _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
