package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchSidesTest {

    BinarySearchSides bs;

    @BeforeEach
    void setUp() {
        bs = new BinarySearchSides();
    }

    @Test
    void testSides() {
        int[] arr = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2};
        assertEquals(4, bs.binarySearchLeft(arr, 1));
        assertEquals(0, bs.binarySearchLeft(arr, 0));
        assertEquals(-1, bs.binarySearchLeft(arr, -1));
        assertEquals(10, bs.binarySearchLeft(arr, 2));
        assertEquals(9, bs.binarySearchRight(arr, 1));
        assertEquals(12, bs.binarySearchRight(arr, 2));
        assertEquals(3, bs.binarySearchRight(arr, 0));
        assertEquals(-1, bs.binarySearchRight(arr, -1));
    }

    @Test
    void testFloorAndCeil() {
        int[] arr = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 3, 3, 3};
        assertEquals(1, bs.binarySearchFloor(arr, 2));
        assertEquals(1, bs.binarySearchFloor(arr, 3));
        assertEquals(3, bs.binarySearchFloor(arr, 4));
        assertEquals(0, bs.binarySearchFloor(arr, 1));
        assertEquals(-1, bs.binarySearchFloor(arr, 0));

        assertEquals(3, bs.binarySearchCeil(arr, 1));
        assertEquals(3, bs.binarySearchCeil(arr, 2));
        assertEquals(-1, bs.binarySearchCeil(arr, 4));
        assertEquals(0, bs.binarySearchCeil(arr, -1));
        assertEquals(1, bs.binarySearchCeil(arr, 0));
    }

    @Test
    void testFloorAndCeilOrEqual() {
        int[] arr = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 3, 3, 3};
        assertEquals(4, bs.binarySearchFloorOrEqual(arr, 1));
        assertEquals(9, bs.binarySearchFloorOrEqual(arr, 2));
        assertEquals(12, bs.binarySearchFloorOrEqual(arr, 12));
        assertEquals(0, bs.binarySearchFloorOrEqual(arr, 0));
        assertEquals(-1, bs.binarySearchFloorOrEqual(arr, -1));

        assertEquals(3, bs.binarySearchCeilOrEqual(arr, 0));
        assertEquals(0, bs.binarySearchCeilOrEqual(arr, -1));
        assertEquals(10, bs.binarySearchCeilOrEqual(arr, 2));
        assertEquals(9, bs.binarySearchCeilOrEqual(arr, 1));
        assertEquals(12, bs.binarySearchCeilOrEqual(arr, 3));
        assertEquals(13, bs.binarySearchCeilOrEqual(arr, 4));
    }

}
