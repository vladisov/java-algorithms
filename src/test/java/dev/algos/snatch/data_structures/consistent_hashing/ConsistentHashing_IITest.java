package dev.algos.snatch.data_structures.consistent_hashing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsistentHashing_IITest {

    @Test
    void test() {
        ConsistentHashing_II ch = ConsistentHashing_II.create(2, 1);
        ch.addMachine(17);
        assertEquals(17, ch.getMachineIdByHashCode(4));
        ch.addMachine(5);
        ch.addMachine(11);

    }
}
