package dev.algos.snatch.interview_problems.sweep_line;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)
 * <p>
 * Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.
 * <p>
 * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * Example 2:
 * <p>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 */
public class CarPooling {

    /**
     * Time O(NlogN)
     * Space O(N)
     */
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]); // no need, it's sorted already
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] trip : trips) {
            if (capacity < 0) return false;

            while (!queue.isEmpty() && queue.peek()[2] <= trip[1]) {
                capacity += queue.poll()[0];
            }

            queue.add(trip);
            capacity -= trip[0];
        }
        return capacity >= 0;
    }

    /**
     * Time O(M) where m - last stop
     * Space O(M)
     */
//    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
//        val stops = IntArray(10001)
//        for(trip in trips) {
//            stops[trip[1]] += trip[0];
//            stops[trip[2]] += -trip[0];
//        }
//        for(i in 1 until stops.size) {
//            stops[i] += stops[i - 1]
//            if (stops[i] > capacity) return false
//        }
//        return true
//    }
}
