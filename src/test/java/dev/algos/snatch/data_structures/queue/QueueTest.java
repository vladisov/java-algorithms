package dev.algos.snatch.data_structures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueueTest {

    Queue<Integer> queue;

    @BeforeEach
    public void setup() {
        queue = new Queue<>();
    }

    @Test
    public void emptyQueue() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void pollOnEmpty() {
        assertThrows(Exception.class, () -> queue.poll());
    }

    @Test
    public void peekOnEmpty() {
        assertThrows(Exception.class, () -> queue.peek());
    }

    @Test
    public void offer() {
        queue.offer(2);
        assertEquals(1, queue.size());
    }

    @Test
    public void peek() {
        queue.offer(2);
        assertEquals(2, queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    public void poll() {
        queue.offer(2);
        assertEquals(2, queue.poll());
        assertEquals(0, queue.size());
    }

    @Test
    public void exhaustively() {
        assertTrue(queue.isEmpty());
        queue.offer(1);
        assertFalse(queue.isEmpty());
        queue.offer(2);
        assertEquals(2, queue.size());
        assertEquals(1, queue.peek());
        assertEquals(2, queue.size());
        assertEquals(1, queue.poll());
        assertEquals(1, queue.size());
        assertEquals(2, queue.peek());
        assertEquals(1, queue.size());
        assertEquals(2, queue.poll());
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

}
