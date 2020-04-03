package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.PriorityQueue;
import java.util.Queue;

public class GirlsAndBoys {

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
