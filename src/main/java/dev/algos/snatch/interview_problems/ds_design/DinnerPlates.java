package dev.algos.snatch.interview_problems.ds_design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class DinnerPlates {
    private Map<Integer, Stack<Integer>> map;
    private int capacity;
    private PriorityQueue<Integer> indexHeap;
    private int maxIndex;

    public DinnerPlates(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.indexHeap = new PriorityQueue<>();
        this.maxIndex = -1;
    }

    public void push(int val) {
        if (indexHeap.isEmpty()) {
            maxIndex++;
            map.put(maxIndex, new Stack<Integer>());
            map.get(maxIndex).add(val);
            if (map.get(maxIndex).size() < capacity) {
                indexHeap.add(maxIndex);
            }
            return;
        }
        Integer index = indexHeap.peek();
        map.putIfAbsent(index, new Stack<>());
        Stack<Integer> stack = map.get(index);
        stack.add(val);
        if (stack.size() == capacity) {
            indexHeap.poll();
        }
        if (index > maxIndex) {
            maxIndex = index;
        }
    }

    public int pop() {
        if (maxIndex == -1) {
            return -1;
        }

        Stack<Integer> stack = map.get(maxIndex);
        while (stack.isEmpty() && maxIndex >= 0) {
            maxIndex--;
            stack = map.get(maxIndex);
        }
        if (maxIndex == -1) return -1;

        int val = stack.pop();
        if (stack.isEmpty()) {
            maxIndex--;
        }
        if (stack.size() == capacity - 1 && maxIndex != -1) {
            indexHeap.add(maxIndex);
        }
        return val;
    }

    public int popAtStack(int index) {
        if (!map.containsKey(index)) return -1;
        Stack<Integer> stack = map.get(index);
        if (stack.isEmpty()) return -1;

        int val = stack.pop();
        if (stack.isEmpty() && maxIndex == index) {
            maxIndex--;
        }
        if (stack.size() == capacity - 1) {
            indexHeap.add(index);
        }
        return val;
    }
}
