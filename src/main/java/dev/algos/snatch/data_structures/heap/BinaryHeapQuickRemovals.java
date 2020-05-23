package dev.algos.snatch.data_structures.heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * A min priority queue implementation using a binary heap.
 *
 * @param <T> the type of elements held in this queue
 */
public class BinaryHeapQuickRemovals<T extends Comparable<T>> {

    // A dynamic list to track the elements inside the heap
    private final List<T> heap;

    /**
     * This map keeps track of the possible indices a particular
     * node value is found in the heap. Having this mapping lets
     * us have O(log(n)) removals and O(1) element containment check
     * at the cost of some additional space and minor overhead
     */
    private final Map<T, TreeSet<Integer>> map = new HashMap<>();

    // Construct and initially empty priority queue
    public BinaryHeapQuickRemovals() {
        this(1);
    }

    // Construct a priority queue with an initial capacity
    public BinaryHeapQuickRemovals(int sz) {
        heap = new ArrayList<>(sz);
    }

    /**
     * Construct a priority queue using heapify in O(n) time
     *
     * @param elements to insert
     */
    public BinaryHeapQuickRemovals(T[] elements) {

        int heapSize = elements.length;
        heap = new ArrayList<>(heapSize);

        // Place all element in heap
        for (int i = 0; i < heapSize; i++) {
            addToMap(elements[i], i);
            heap.add(elements[i]);
        }

        // Heapify process, O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
            sink(i);
        }
    }

    /**
     * Priority queue construction, O(nlog(n))
     *
     * @param elements to insert
     */
    public BinaryHeapQuickRemovals(Collection<T> elements) {
        this(elements.size());
        for (T elem : elements) {
            add(elem);
        }
    }

    /**
     * Retrieves and removes the head of this queue, O(log(n))
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    public T poll() {
        return removeAt(0);
    }

    /**
     * Returns the value of the element with the lowest priority in this priority queue.
     * If the priority queue is empty null is returned.
     *
     * @return value of the element with the lowest priority
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    /**
     * Adds an element to the priority queue, the element must not be null,
     * O(log(n))
     *
     * @param element to add
     */
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        heap.add(element);

        int indexOfLastElem = size() - 1;
        addToMap(element, indexOfLastElem);

        swim(indexOfLastElem);
    }

    /**
     * Removes a particular element in the heap, O(n)
     *
     * @param element to remove
     * @return true if element is removed, false otherwise;
     */
    public boolean remove(T element) {
        if (element == null) {
            return false;
        }
        // Linear removal via search, O(n)
        // for (int i = 0; i < heapSize; i++) {
        //   if (element.equals(heap.get(i))) {
        //     removeAt(i);
        //     return true;
        //   }
        // }

        // Logarithmic removal with map, O(log(n))
        Integer index = mapGet(element);
        if (index != null) {
            removeAt(index);
        }
        return index != null;
    }

    public boolean contains(T elem) {
        //map lookup for O(1)
        if (elem == null) {
            return false;
        }
        return map.containsKey(elem);

        // Linear scan to check containment
        //for (int i = 0; i < size(); i++) {
        //    if (heap.get(i).equals(elem)) {
        //        return true;
        //    }
        //}
        // return false;
    }

    /**
     * Recursively checks if this heap is a min heap
     * This method is just for testing purposes to make sure the heap invariant is still being maintained
     * Called this method with k=0 to start at the root
     *
     * @param k node position
     * @return true if this heap is a min heap
     */
    public boolean isMinHeap(int k) {
        // If we are outside the bounds of the heap return true
        int heapSize = size();
        if (k >= heapSize) {
            return true;
        }

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        // Make sure that the current node k is less than
        // both of its children left, and right if they exist
        // return false otherwise to indicate an invalid heap
        if (left < heapSize && !less(k, left)) {
            return false;
        }
        if (right < heapSize && !less(k, right)) {
            return false;
        }

        // Recurse on both children to make sure they're also valid heaps
        return isMinHeap(left) && isMinHeap(right);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return heap.size();
    }

    public void clear() {
        heap.clear();
        map.clear();
    }

    /**
     * Removes a node at particular index, O(log(n))
     *
     * @param i index
     * @return removed element
     */
    private T removeAt(int i) {
        if (isEmpty()) {
            return null;
        }
        int indexOfLastElem = size() - 1;
        T removedData = heap.get(i);
        swap(i, indexOfLastElem);

        // Obliterate the value
        heap.remove(indexOfLastElem);
        mapRemove(removedData, indexOfLastElem);

        // Check if the last element was removed
        if (i == indexOfLastElem) {
            return removedData;
        }
        T elem = heap.get(i);

        // Try sinking element
        sink(i);

        // If sinking did not work try swimming
        if (heap.get(i).equals(elem)) {
            swim(i);
        }
        return removedData;
    }

    /**
     * Perform bottom up node swim, O(log(n))
     *
     * @param k element
     */
    private void swim(int k) {

        // Grab the index of the next parent node WRT to k
        int parent = (k - 1) / 2;

        // Keep swimming while we have not reached the
        // root and while we're less than our parent.
        while (k > 0 && less(k, parent)) {
            // Exchange k with the parent
            swap(parent, k);
            k = parent;
            // Grab the index of the next parent node WRT to k
            parent = (k - 1) / 2;
        }
    }

    /**
     * Top down node sink, O(log(n))
     *
     * @param k element
     */
    private void sink(int k) {
        int heapSize = size();
        while (true) {
            int left = 2 * k + 1; // Left  node
            int right = 2 * k + 2; // Right node
            int smallest = left; // Assume left is the smallest node of the two children

            // Find which is smaller left or right
            // If right is smaller set smallest to be right
            if (right < heapSize && less(right, left)) {
                smallest = right;
            }

            // Stop if we're outside the bounds of the tree
            // or stop early if we cannot sink k anymore
            if (left >= heapSize || less(k, smallest)) {
                break;
            }

            // Move down the tree following the smallest node
            swap(smallest, k);
            k = smallest;
        }
    }

    /**
     * Tests if the value of node i <= node j
     * This method assumes i & j are valid indices, O(1)
     *
     * @param i first element
     * @param j second element
     * @return true if first element is smaller then second one, false otherwise
     */
    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    /**
     * Add a node value and its index to the map
     *
     * @param value to add
     * @param index where element is located
     */
    private void addToMap(T value, int index) {

        TreeSet<Integer> set = map.get(value);

        // New value being inserted into map
        if (set == null) {
            set = new TreeSet<>();
            set.add(index);
            map.put(value, set);
        } else {
            // Value already exists in map
            set.add(index);
        }
    }

    /**
     * Removes the index at a given value, O(log(n))
     *
     * @param value to remove
     * @param index where value is located
     */
    private void mapRemove(T value, int index) {
        TreeSet<Integer> set = map.get(value);
        set.remove(index); // TreeSets take O(log(n)) removal time
        if (set.isEmpty()) {
            map.remove(value);
        }
    }

    /**
     * Extract an index position for the given value
     * NOTE: If a value exists multiple times in the heap the highest
     *
     * @param value of the heap
     * @return index is returned (this has arbitrarily been chosen)
     */
    private Integer mapGet(T value) {
        TreeSet<Integer> set = map.get(value);
        if (set != null) {
            return set.last();
        }
        return null;
    }

    /**
     * Exchange the index of two nodes internally within the map
     *
     * @param val1      first value
     * @param val2      second value
     * @param val1Index first value index
     * @param val2Index second value index
     */
    private void mapSwap(T val1, T val2, int val1Index, int val2Index) {

        Set<Integer> set1 = map.get(val1);
        Set<Integer> set2 = map.get(val2);

        set1.remove(val1Index);
        set2.remove(val2Index);

        set1.add(val2Index);
        set2.add(val1Index);
    }

    /**
     * Swap two nodes. Assumes i & j are valid, O(1)
     *
     * @param i first node
     * @param j second node
     */
    private void swap(int i, int j) {
        T firstNode = heap.get(i);
        T secondNode = heap.get(j);

        heap.set(i, secondNode);
        heap.set(j, firstNode);
        mapSwap(firstNode, secondNode, i, j);
    }
}

