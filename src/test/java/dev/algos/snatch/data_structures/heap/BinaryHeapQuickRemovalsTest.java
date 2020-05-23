package dev.algos.snatch.data_structures.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

class BinaryHeapQuickRemovalsTest {

    private static final int LOOPS = 100;
    private static final int MAX_SZ = 100;

    @Test
    public void isEmpty() {
        BinaryHeapQuickRemovals<Integer> q = new BinaryHeapQuickRemovals<>();
        assertEquals(0, q.size());
        assertTrue(q.isEmpty());
        assertNull(q.poll());
        assertNull(q.peek());
    }

    @Test
    public void heapProperty() {

        BinaryHeapQuickRemovals<Integer> q = new BinaryHeapQuickRemovals<>();
        Integer[] nums = {3, 2, 5, 6, 7, 9, 4, 8, 1};

        // Try manually creating heap
        for (int n : nums) {
            q.add(n);
        }
        for (int i = 1; i <= 9; i++) {
            assertEquals(i, q.poll());
        }

        q.clear();

        // Try heapify constructor
        q = new BinaryHeapQuickRemovals<>(nums);
        for (int i = 1; i <= 9; i++) {
            assertEquals(i, q.poll());
        }
    }

    @Test
    public void heapify() {

        for (int i = 1; i < LOOPS; i++) {

            Integer[] lst = genRandArray(i);
            BinaryHeapQuickRemovals<Integer> pq = new BinaryHeapQuickRemovals<>(lst);

            PriorityQueue<Integer> pq2 = new PriorityQueue<>(i);
            pq2.addAll(Arrays.asList(lst));

            assertTrue(pq.isMinHeap(0));
            while (!pq2.isEmpty()) {
                assertEquals(pq.poll(), pq2.poll());
            }
        }
    }

    @Test
    public void clear() {

        BinaryHeapQuickRemovals<String> q;
        String[] strings = {"aa", "bb", "cc", "dd", "ee"};
        q = new BinaryHeapQuickRemovals<>(strings);
        q.clear();
        assertEquals(0, q.size());
        assertTrue(q.isEmpty());
    }

    @Test
    public void containment() {

        String[] strings = {"aa", "bb", "cc", "dd", "ee"};
        BinaryHeapQuickRemovals<String> q = new BinaryHeapQuickRemovals<>(strings);
        q.remove("aa");
        assertFalse(q.contains("aa"));
        q.remove("bb");
        assertFalse(q.contains("bb"));
        q.remove("cc");
        assertFalse(q.contains("cc"));
        q.remove("dd");
        assertFalse(q.contains("dd"));
        q.clear();
        assertFalse(q.contains("ee"));
    }

    @Test
    public void containmentRandomized() {

        for (int i = 0; i < LOOPS; i++) {

            List<Integer> randNums = genRandList(100);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            BinaryHeapQuickRemovals<Integer> bhqr = new BinaryHeapQuickRemovals<>();
            for (Integer randNum : randNums) {
                bhqr.add(randNum);
                pq.add(randNum);
            }

            for (int randVal : randNums) {

                assertEquals(bhqr.contains(randVal), pq.contains(randVal));
                bhqr.remove(randVal);
                pq.remove(randVal);
                assertEquals(bhqr.contains(randVal), pq.contains(randVal));
            }
        }
    }

    @Test
    public void removing() {

        Integer[] in = {1, 2, 3, 4, 5, 6, 7};
        Integer[] removeOrder = {1, 3, 6, 4, 5, 7, 2};
        sequentialRemoving(in, removeOrder);

        in = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        removeOrder = new Integer[] {7, 4, 6, 10, 2, 5, 11, 3, 1, 8, 9};
        sequentialRemoving(in, removeOrder);

        in = new Integer[] {8, 1, 3, 3, 5, 3};
        removeOrder = new Integer[] {3, 3, 5, 8, 1, 3};
        sequentialRemoving(in, removeOrder);

        in = new Integer[] {7, 7, 3, 1, 1, 2};
        removeOrder = new Integer[] {2, 7, 1, 3, 7, 1};
        sequentialRemoving(in, removeOrder);

        in = new Integer[] {32, 66, 93, 42, 41, 91, 54, 64, 9, 35};
        removeOrder = new Integer[] {64, 93, 54, 41, 35, 9, 66, 42, 32, 91};
        sequentialRemoving(in, removeOrder);
    }

    @Test
    public void removingDuplicates() {

        Integer[] in = new Integer[] {2, 7, 2, 11, 7, 13, 2};
        BinaryHeapQuickRemovals<Integer> pq = new BinaryHeapQuickRemovals<>(in);

        assertEquals(2, pq.peek());
        pq.add(3);

        assertEquals(2, pq.poll());
        assertEquals(2, pq.poll());
        assertEquals(2, pq.poll());
        assertEquals(3, pq.poll());
        assertEquals(7, pq.poll());
        assertEquals(7, pq.poll());
        assertEquals(11, pq.poll());
        assertEquals(13, pq.poll());
    }

    @Test
    public void randomizedPolling() {

        for (int i = 0; i < LOOPS; i++) {

            List<Integer> randNums = genRandList(i);
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            BinaryHeapQuickRemovals<Integer> pq2 = new BinaryHeapQuickRemovals<>();

            // Add all the elements to both priority queues
            for (Integer value : randNums) {
                pq1.offer(value);
                pq2.add(value);
            }

            while (!pq1.isEmpty()) {

                assertTrue(pq2.isMinHeap(0));
                assertEquals(pq1.size(), pq2.size());
                assertEquals(pq1.peek(), pq2.peek());
                assertEquals(pq1.contains(pq1.peek()), pq2.contains(pq2.peek()));

                Integer v1 = pq1.poll();
                Integer v2 = pq2.poll();

                assertEquals(v1, v2);
                assertEquals(pq1.peek(), pq2.peek());
                assertEquals(pq1.size(), pq2.size());
                assertTrue(pq2.isMinHeap(0));
            }
        }
    }

    @Test
    public void randomizedRemoving() {

        for (int i = 0; i < LOOPS; i++) {

            List<Integer> randNums = genRandList(i);
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            BinaryHeapQuickRemovals<Integer> pq2 = new BinaryHeapQuickRemovals<>();

            // Add all the elements to both priority queues
            for (Integer value : randNums) {
                pq1.offer(value);
                pq2.add(value);
            }

            Collections.shuffle(randNums);
            int index = 0;

            while (!pq1.isEmpty()) {

                int removeNum = randNums.get(index++);

                assertTrue(pq2.isMinHeap(0));
                assertEquals(pq1.size(), pq2.size());
                assertEquals(pq1.peek(), pq2.peek());
                pq1.remove(removeNum);
                pq2.remove(removeNum);
                assertEquals(pq1.peek(), pq2.peek());
                assertEquals(pq1.size(), pq2.size());
                assertTrue(pq2.isMinHeap(0));
            }
        }
    }

    @Test
    public void pqReusability() {

        List<Integer> sizes = genUniqueRandList();

        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        BinaryHeapQuickRemovals<Integer> pq = new BinaryHeapQuickRemovals<>();

        for (int sz : sizes) {

            pq.clear();
            PQ.clear();

            List<Integer> nums = genRandList(sz);
            for (int n : nums) {
                pq.add(n);
                PQ.add(n);
            }

            Collections.shuffle(nums);

            for (int i = 0; i < sz / 2; i++) {

                // Sometimes add a new number into the BinaryHeapQuickRemovals
                if (0.25 < Math.random()) {
                    int randNum = (int) (Math.random() * 10000);
                    PQ.add(randNum);
                    pq.add(randNum);
                }

                int removeNum = nums.get(i);

                assertTrue(pq.isMinHeap(0));
                assertEquals(PQ.size(), pq.size());
                assertEquals(PQ.peek(), pq.peek());

                PQ.remove(removeNum);
                pq.remove(removeNum);

                assertEquals(PQ.peek(), pq.peek());
                assertEquals(PQ.size(), pq.size());
                assertTrue(pq.isMinHeap(0));
            }
        }
    }

    private void sequentialRemoving(Integer[] in, Integer[] removeOrder) {

        assertEquals(in.length, removeOrder.length);

        BinaryHeapQuickRemovals<Integer> bhqr = new BinaryHeapQuickRemovals<>(in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int value : in) {
            pq.offer(value);
        }

        assertTrue(bhqr.isMinHeap(0));

        for (int elem : removeOrder) {

            assertSame(bhqr.peek(), pq.peek());
            assertEquals(bhqr.remove(elem), pq.remove(elem));
            assertSame(bhqr.size(), pq.size());
            assertTrue(bhqr.isMinHeap(0));
        }
        assertTrue(bhqr.isEmpty());
    }

    private Integer[] genRandArray(int sz) {
        Integer[] lst = new Integer[sz];
        for (int i = 0; i < sz; i++) {
            lst[i] = (int) (Math.random() * MAX_SZ);
        }
        return lst;
    }

    // Generate a list of random numbers
    private List<Integer> genRandList(int sz) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) {
            lst.add((int) (Math.random() * MAX_SZ));
        }
        return lst;
    }

    // Generate a list of unique random numbers
    private List<Integer> genUniqueRandList() {
        List<Integer> lst = new ArrayList<>(LOOPS);
        for (int i = 0; i < LOOPS; i++) {
            lst.add(i);
        }
        Collections.shuffle(lst);
        return lst;
    }
}

