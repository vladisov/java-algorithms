package dev.algos.snatch.data_structures;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public void solution(int X, int Y) {

        var max = Math.max(X, Y);
        var min = Math.min(X, Y);
        var i = max / (min + 1);
        var j = max % (min + 1);
        var tmp = i + j;
        var i1 = max / min;
        System.out.println(Math.min(tmp, i1));
    }

    public void solution1(int X, int Y) {
        if (X == 1) {
            System.out.println(Y / 2);
            return;
        }
        if (Y == 1) {
            System.out.println(X / 2);
            return;
        }
        var max = Math.max(X, Y);
        var min = Math.min(X, Y);
        var i = max / (min);
        var j = max % (min);
        System.out.println( Math.max(i, j));
    }

    int girlsBoys(int b, int g) {
        if (b == g) {
            return 1;
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int i = Math.max(b, g);
        int j = Math.min(b, g);
        maxHeap.add(i);

        for (int k = 0; k < j; k++) {
            int maxSoFar = maxHeap.poll();
            int left = maxSoFar / 2;
            int right = maxSoFar % 2 + left;
            maxHeap.add(left);
            maxHeap.add(right);
        }

        return maxHeap.peek();
    }

}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution1(5,1);
        s.solution1(10, 3);
        s.solution1(8,3);
       /* System.out.println(s.girlsBoys(5, 1));
        System.out.println(s.girlsBoys(10, 3));
        System.out.println(s.girlsBoys(8, 3));*/
    }
}
