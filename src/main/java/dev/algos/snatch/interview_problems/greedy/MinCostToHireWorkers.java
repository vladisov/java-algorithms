package dev.algos.snatch.interview_problems.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].
 * <p>
 * Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:
 * <p>
 * Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
 * Every worker in the paid group must be paid at least their minimum wage expectation.
 * Return the least amount of money needed to form a paid group satisfying the above conditions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: quality = [10,20,5], wage = [70,50,30], K = 2
 * Output: 105.00000
 * Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
 * Example 2:
 * <p>
 * Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
 * Output: 30.66667
 * Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately.
 */
public class MinCostToHireWorkers {

    /**
     * Time O(NlogN)
     * Space O(N)
     */
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        int n = q.length;
        double[][] workers = new double[n][2];
        // build array: ratio:qualitySum
        for (int i = 0; i < n; i++) {
            workers[i] = new double[]{(double) w[i] / q[i], q[i]};
        }
        //sort it
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Double> queue = new PriorityQueue<>();
        double qualitySum = 0, wage = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            //add up quality to current total
            qualitySum += workers[i][1];
            // add to queue
            queue.add(-workers[i][1]);
            if (queue.size() > K) {
                qualitySum += queue.poll();
            }
            if (queue.size() == K) {
                double ratio = workers[i][0];
                // multiply quality by ratio to get cost current cost
                wage = Math.min(qualitySum * ratio, wage);
            }
        }
        return wage;
    }
}
