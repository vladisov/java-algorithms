package dev.algos.snatch.interview_problems.greedy;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * <p>
 * Note:
 * <p>
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 * Example 1:
 * <p>
 * Input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 */
public class GasStation {

    /**
     * Time O(N)
     * Space O(1)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0, sumCost = 0, start = 0, n = gas.length, tank = 0;
        for (int i = 0; i < n; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        }
        return start == n ? 0 : start;
    }
}
