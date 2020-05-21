package dev.algos.snatch.interview_problems.bit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.toBinaryString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BitTricksTest {

    BitTricks bitTricks;

    @BeforeEach
    void setUp() {
        bitTricks = new BitTricks();
    }

    @Test
    void testSetIthBit() {
        System.out.println("8 in binary = " + toBinaryString(8)); //1000
        assertEquals("1001", toBinaryString(bitTricks.setBit(8, 0)));
        assertEquals("1010", toBinaryString(bitTricks.setBit(8, 1)));
        assertEquals("1100", toBinaryString(bitTricks.setBit(8, 2)));
        //greater than number of bits
        assertEquals("11000", toBinaryString(bitTricks.setBit(8, 4)));
        assertEquals("101000", toBinaryString(bitTricks.setBit(8, 5)));
        assertEquals("1001000", toBinaryString(bitTricks.setBit(8, 6)));
    }

    @Test
    void testGetIthBit() {
        System.out.println("8 in binary = " + toBinaryString(8)); //1000
        assertFalse(bitTricks.getBit(8, 0));
        assertFalse(bitTricks.getBit(8, 10));
        assertTrue(bitTricks.getBit(8, 3));
    }

    @Test
    void testFlipIthBit() {
        System.out.println("8 in binary = " + toBinaryString(8)); //1000
        assertEquals("1010", toBinaryString(bitTricks.flipBit(8, 1)));
        assertEquals("0", toBinaryString(bitTricks.flipBit(8, 3)));
        assertEquals("101000", toBinaryString(bitTricks.flipBit(8, 5)));
    }

    @Test
    void testClearIthBit() {
        System.out.println("8 in binary = " + toBinaryString(8)); //1000
        System.out.println("9 in binary = " + toBinaryString(9)); //1001
        assertEquals("0", toBinaryString(bitTricks.clearBit(8, 3)));
        assertEquals("1000", toBinaryString(bitTricks.clearBit(9, 0)));
    }

    @Test
    void testComplement() {
        System.out.println("9 in binary = " + toBinaryString(9)); //"1001
        assertEquals("11111111111111111111111111110110", toBinaryString(bitTricks.complement(9)));
    }

    @Test
    void testLeftShift() {
        assertEquals("100", toBinaryString(bitTricks.leftShift(2, 1)));
        assertEquals(4, bitTricks.leftShift(2, 1));
        assertEquals("1000", toBinaryString(bitTricks.leftShift(2, 2)));
        assertEquals(8, bitTricks.leftShift(2, 2));
        assertEquals("10000", toBinaryString(bitTricks.leftShift(2, 3)));
        assertEquals(16, bitTricks.leftShift(2, 3));
        assertEquals("10000000000", toBinaryString(bitTricks.leftShift(2, 9)));
        assertEquals(1024, bitTricks.leftShift(2, 9));

        assertEquals("110", toBinaryString(bitTricks.leftShift(3, 1)));
        assertEquals(6, bitTricks.leftShift(3, 1));
        assertEquals("1100", toBinaryString(bitTricks.leftShift(3, 2)));
        assertEquals(12, bitTricks.leftShift(3, 2));
    }

    @Test
    void testExactlyOneBitIsSet() {
        System.out.println("8 in binary = " + toBinaryString(8)); //1000
        System.out.println("9 in binary = " + toBinaryString(9)); //1001
        assertFalse(bitTricks.checkExactlyOneBitSet(9));
        assertTrue(bitTricks.checkExactlyOneBitSet(8));
    }

    @Test
    void testClearBitsFromMostSignificantBitToIth() {
        System.out.println("7 in binary = " + toBinaryString(7)); //111
        System.out.println("8 in binary = " + toBinaryString(8)); //1000
        System.out.println("9 in binary = " + toBinaryString(9)); //1001
        assertEquals("1", toBinaryString(bitTricks.clearBitsFromMostSignificantBitToIth(9, 2)));
        assertEquals("0", toBinaryString(bitTricks.clearBitsFromMostSignificantBitToIth(8, 2)));
        assertEquals("11", toBinaryString(bitTricks.clearBitsFromMostSignificantBitToIth(7, 2)));
        assertEquals(3, bitTricks.clearBitsFromMostSignificantBitToIth(7, 2));
    }

    @Test
    void testClearBitsFromIthTo0() {
        System.out.println("7 in binary = " + toBinaryString(7)); //111
        System.out.println("8 in binary = " + toBinaryString(8)); //1000
        System.out.println("9 in binary = " + toBinaryString(9)); //1001
        assertEquals("100", toBinaryString(bitTricks.clearBitsFromIthTo0(7, 1)));
        assertEquals("0", toBinaryString(bitTricks.clearBitsFromIthTo0(8, 3)));
        assertEquals("1000", toBinaryString(bitTricks.clearBitsFromIthTo0(9, 0)));
    }
}
