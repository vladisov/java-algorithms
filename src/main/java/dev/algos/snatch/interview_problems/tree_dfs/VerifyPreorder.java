package dev.algos.snatch.interview_problems.tree_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 */
public class VerifyPreorder {

    /**
     * Time O(N)
     * Space O(N)
     */
    public boolean verifyPreorder(int[] preorder) {
        Queue<Integer> queue = new LinkedList<>();
        for (int num : preorder) queue.add(num);
        build(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return queue.isEmpty();
    }

    private void build(Queue<Integer> queue, int min, int max) {
        if (queue.isEmpty()) return;
        int val = queue.peek();
        if (val < min || val > max) return;
        queue.poll();
        build(queue, min, val);
        build(queue, val, max);
    }

}
