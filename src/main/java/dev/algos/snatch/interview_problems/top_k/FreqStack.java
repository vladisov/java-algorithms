package dev.algos.snatch.interview_problems.top_k;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * <p>
 * FreqStack has two functions:
 * <p>
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * Output: [null,null,null,null,null,null,null,5,7,5,4]
 * Explanation:
 * After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:
 * <p>
 * pop() -> returns 5, as 5 is the most frequent.
 * The stack becomes [5,7,5,7,4].
 * <p>
 * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
 * The stack becomes [5,7,5,4].
 * <p>
 * pop() -> returns 5.
 * The stack becomes [5,7,4].
 * <p>
 * pop() -> returns 4.
 * The stack becomes [5,7].
 */
class FreqStack {
    private int sequence;
    private PriorityQueue<Element> maxHeap;
    private Map<Integer, Integer> frequencyMap;

    public FreqStack() {
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.getFrequency() == b.getFrequency()) {
                return b.getSequence() - a.getSequence();
            }
            return b.getFrequency() - a.getFrequency();
        });
        frequencyMap = new HashMap<>();
    }

    /**
     * O(logN)
     */
    public void push(int x) {
        frequencyMap.put(x, frequencyMap.getOrDefault(x, 0) + 1);
        maxHeap.add(new Element(sequence++, x, frequencyMap.get(x)));
    }

    /**
     * O(1)
     */
    public int pop() {
        if (maxHeap.isEmpty()) {
            return -1;
        }

        var element = maxHeap.poll();
        int val = element.getVal();
        frequencyMap.put(val, frequencyMap.get(val) - 1);
        if (frequencyMap.get(val) == 0) {
            frequencyMap.remove(val);
        }
        return val;
    }


    static class Element {
        private int sequence;
        private int val;
        private int frequency;

        public Element(int sequence, int val, int frequency) {
            this.sequence = sequence;
            this.val = val;
            this.frequency = frequency;
        }

        public int getSequence() {
            return sequence;
        }

        public int getVal() {
            return val;
        }

        public int getFrequency() {
            return frequency;
        }
    }
}
