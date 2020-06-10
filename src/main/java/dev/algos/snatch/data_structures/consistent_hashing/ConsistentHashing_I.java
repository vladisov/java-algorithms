package dev.algos.snatch.data_structures.consistent_hashing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * for n = 1, return
 * <p>
 * [
 * [0,359,1]
 * ]
 * represent 0~359 belongs to machine 1.
 * <p>
 * for n = 2, return
 * <p>
 * [
 * [0,179,1],
 * [180,359,2]
 * ]
 * for n = 3, return
 * <p>
 * [
 * [0,89,1]
 * [90,179,3],
 * [180,359,2]
 * ]
 * for n = 4, return
 * <p>
 * [
 * [0,89,1],
 * [90,179,3],
 * [180,269,2],
 * [270,359,4]
 * ]
 * for n = 5, return
 * <p>
 * [
 * [0,44,1],
 * [45,89,5],
 * [90,179,3],
 * [180,269,2],
 * [270,359,4]
 * ]
 */
public class ConsistentHashing_I {

    /**
     * Results in uneven load
     */
    public List<Machine> consistentHashing(int n) {
        List<Machine> results = new ArrayList<>();
        results.add(new Machine(0, 359, 1));
        for (int i = 1; i < n; i++) {
            int maxIntervalIndex = 0;
            for (int j = 0; j < i; j++) {
                //find machine with max interval
                Machine machine = results.get(j);
                Machine maxMachine = results.get(maxIntervalIndex);
                int machineInterval = machine.getEnd() - machine.getStart();
                int maxMachineInterval = maxMachine.getEnd() - maxMachine.getStart();
                if (machineInterval > maxMachineInterval) {
                    maxIntervalIndex = j;
                }
            }
            int start = results.get(maxIntervalIndex).getStart();
            int end = results.get(maxIntervalIndex).getEnd();
            //update max machine
            results.get(maxIntervalIndex).setEnd((start + end) / 2); // find middle value

            Machine newMachine = new Machine((start + end) / 2 + 1, end, i + 1);
            results.add(newMachine);
        }
        results.sort(Comparator.comparingInt(Machine::getStart)); // useless step, just for consistent result
        return results;
    }

    public List<Machine> consistentHashingPQ(int n) {
        Machine firstMachine = new Machine(0, 359, 1);
        PriorityQueue<Machine> maxHeap = new PriorityQueue<>((a, b) -> (b.getInterval() - a.getInterval()));
        maxHeap.add(firstMachine);
        for (int i = 1; i < n; i++) {
            Machine maxMachine = maxHeap.poll();
            int start = maxMachine.getStart();
            int end = maxMachine.getEnd();
            //update max machine
            maxMachine.setEnd((start + end) / 2);
            Machine newMachine = new Machine((start + end) / 2 + 1, end, i + 1);
            maxHeap.add(newMachine);
            maxHeap.add(maxMachine);
        }
        List<Machine> results = new ArrayList<>(maxHeap);
        results.sort(Comparator.comparingInt(Machine::getStart)); // useless step, just for consistent result
        return results;
    }
}
