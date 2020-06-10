package dev.algos.snatch.data_structures.consistent_hashing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ConsistentHashing_ITest {

    @Test
    void test() {
        ConsistentHashing_I ch = new ConsistentHashing_I();
        assertThat(ch.consistentHashing(4).toString(), equalTo("[[0,89], [90,179], [180,269], [270,359]]"));
        assertThat(ch.consistentHashingPQ(4).toString(), equalTo("[[0,89], [90,179], [180,269], [270,359]]"));
        assertThat(ch.consistentHashing(1).toString(), equalTo("[[0,359]]"));
        assertThat(ch.consistentHashingPQ(1).toString(), equalTo("[[0,359]]"));
        assertThat(ch.consistentHashing(5).toString(), equalTo("[[0,44], [45,89], [90,179], [180,269], [270,359]]"));
        assertThat(ch.consistentHashingPQ(5).toString(), equalTo("[[0,89], [90,179], [180,224], [225,269], [270,359]]"));
    }
}
