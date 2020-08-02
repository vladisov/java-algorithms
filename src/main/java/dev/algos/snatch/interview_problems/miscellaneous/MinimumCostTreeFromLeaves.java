package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array arr of positive integers, consider all binary trees such that:
 * <p>
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
 * Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.
 * <p>
 * 24            24
 * /  \          /  \
 * 12   4        6    8
 * /  \               / \
 * 6    2             2   4
 */
public class MinimumCostTreeFromLeaves {

    /**
     * Time O(N)
     * Space O(N)
     */
    /*
    When we build a node in the tree, we compared the two numbers a and b.
    In this process,
    the smaller one is removed and we won't use it anymore,
    and the bigger one actually stays.

    The problem can translated as following:
    Given an array A, choose two neighbors in the array a and b,
    we can remove the smaller one min(a,b) and the cost is a * b.
    What is the minimum cost to remove the whole array until only one left?

    To remove a number a, it needs a cost a * b, where b >= a.
    So a has to be removed by a bigger number.
    We want minimize this cost, so we need to minimize b.

    b has two candidates, the first bigger number on the left,
    the first bigger number on the right.

    The cost to remove a is a * min(left, right).
     */
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.MAX_VALUE);
        int total = 0;
        for (int val : arr) {
            while (stack.peek() <= val) {
                int mid = stack.pop();
                int left = stack.peek();
                total += mid * Math.min(left, val);
            }
            stack.add(val);
        }
        while (stack.size() > 2) {
            total += stack.pop() * stack.pop();
        }
        return total;
    }
}
