package dev.algos.snatch.interview_problems.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CriticalConnectionsNetworkTest {

    @Test
    void test() {
        CriticalConnectionsNetwork network = new CriticalConnectionsNetwork();

        List<List<Integer>> result = network.criticalConnections(4, List.of(List.of(0, 1), List.of(1, 2), List.of(2, 0), List.of(1, 3)));
        assertThat(result.toString(), equalTo("[[1, 3]]"));
    }
}
