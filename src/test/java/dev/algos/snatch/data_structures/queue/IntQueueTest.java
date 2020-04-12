package dev.algos.snatch.data_structures.queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntQueueTest {

    @Test
    public void testEmptyQueue() {
        IntQueue queue = new IntQueue(0);
        assertTrue(queue.isEmpty());
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testEnqueueOneElement() {
        IntQueue queue = new IntQueue(1);
        queue.enqueue(77);
        assertEquals(1, queue.size());
    }

    @Test
    public void testAll() {
        int n = 5;
        IntQueue queue = new IntQueue(10);
        assertTrue(queue.isEmpty());
        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
            assertFalse(queue.isEmpty());
        }
        for (int i = 1; i <= n; i++) {
            assertEquals(i, queue.peek());
            assertEquals(i, queue.dequeue());
            assertEquals(queue.size(), n - i);
        }
        assertTrue(queue.isEmpty());
        n = 8;
        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
            assertFalse(queue.isEmpty());
        }
        for (int i = 1; i <= n; i++) {
            assertEquals(i, queue.peek());
            assertEquals(i, queue.dequeue());
            assertEquals(queue.size(), n - i);
        }
        assertTrue(queue.isEmpty());
        n = 9;
        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
            assertFalse(queue.isEmpty());
        }
        for (int i = 1; i <= n; i++) {
            assertEquals(i, queue.peek());
            assertEquals(i, queue.dequeue());
            assertEquals(queue.size(), n - i);
        }
        assertTrue(queue.isEmpty());
        n = 10;
        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
            assertFalse(queue.isEmpty());
        }
        for (int i = 1; i <= n; i++) {
            assertEquals(i, queue.peek());
            assertEquals(i, queue.dequeue());
            assertEquals(queue.size(), n - i);
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeekOneElement() {
        IntQueue queue = new IntQueue(1);
        queue.enqueue(77);
        assertEquals(77, queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    public void testDequeueOneElement() {
        IntQueue queue = new IntQueue(1);
        queue.enqueue(77);
        assertEquals(77, queue.dequeue());
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testRandom() {

        for (int qSize = 1; qSize <= 50; qSize++) {

            IntQueue intQ = new IntQueue(qSize);
            ArrayDeque<Integer> javaQ = new ArrayDeque<>(qSize);

            assertEquals(javaQ.isEmpty(), intQ.isEmpty());
            assertEquals(javaQ.size(), intQ.size());

            for (int operations = 0; operations < 5000; operations++) {

                double r = Math.random();

                if (r < 0.60) {
                    int elem = (int) (1000 * Math.random());
                    if (javaQ.size() < qSize) {
                        javaQ.offer(elem);
                        intQ.enqueue(elem);
                    }
                } else {
                    if (!javaQ.isEmpty()) {
                        assertEquals((int) javaQ.poll(), intQ.dequeue());
                    }
                }

                assertEquals(javaQ.isEmpty(), intQ.isEmpty());
                assertEquals(javaQ.size(), intQ.size());
            }
        }
    }

}
