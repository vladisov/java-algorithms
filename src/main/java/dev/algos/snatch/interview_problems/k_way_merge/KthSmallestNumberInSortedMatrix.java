package dev.algos.snatch.interview_problems.k_way_merge;

import java.util.PriorityQueue;

/**
 * Given an N * NN∗N matrix where each row and column is sorted in ascending order, find the Kth smallest element in the matrix.
 * <p>
 * Example 1:
 * <p>
 * Input: Matrix=[
 * [2, 6, 8],
 * [3, 7, 10],
 * [5, 8, 11]
 * ],
 * K=5
 * Output: 7
 * Explanation: The 5th smallest number in the matrix is 7.
 */
public class KthSmallestNumberInSortedMatrix {

    /**
     * Time complexity (M + NlogM)
     * Space O(M) M - number of rows
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for (int i = 0; i < matrix.length; i++) {
            minHeap.add(new int[]{matrix[i][0], i, 0});
        }
        int j = 0;
        while (!minHeap.isEmpty()) {
            j++;
            int[] map = minHeap.poll();
            int val = map[0];
            int arrIndex = map[1];
            int index = map[2];

            if (j == k) {
                return val;
            }

            int[] array = matrix[arrIndex];
            if (index < array.length - 1) {
                val = array[++index];
                map[0] = val;
                map[2] = index;
                minHeap.offer(map);
            }
        }
        return -1;
    }

    public int kthSmallestEducative(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        // put the 1st element of each row in the min heap
        // we don't need to push more than 'k' elements in the heap
        for (int i = 0; i < matrix.length && i < k; i++)
            minHeap.add(new Node(i, 0));

        // take the smallest (top) element form the min heap, if the running count is equal to k return the number
        // if the row of the top element has more elements, add the next element to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k)
                break;
            node.col++;
            if (matrix[0].length > node.col)
                minHeap.add(node);
        }
        return result;
    }

    static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
