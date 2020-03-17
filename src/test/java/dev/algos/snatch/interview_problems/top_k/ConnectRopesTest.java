package dev.algos.snatch.interview_problems.top_k;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


class ConnectRopesTest {

    @Test
    void test() {
        ConnectRopes instance = new ConnectRopes();
        assertThat(instance.minimumCostToConnectRopes(new int[]{3, 4, 5, 6}), equalTo(36));
        assertThat(instance.minimumCostToConnectRopes(new int[]{1, 3, 11, 5, 2}), equalTo(42));
    }
}
