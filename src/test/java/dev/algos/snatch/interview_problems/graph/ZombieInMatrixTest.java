package dev.algos.snatch.interview_problems.graph;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ZombieInMatrixTest {

    @Test
    void test() {
        ZombieInMatrix zombie = new ZombieInMatrix();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Lists.newArrayList(0, 1, 1, 0, 1));
        list.add(Lists.newArrayList(0, 1, 0, 1, 0));
        list.add(Lists.newArrayList(0, 0, 0, 0, 1));
        list.add(Lists.newArrayList(0, 1, 0, 0, 0));
        assertThat(zombie.minHours(4, 5, list), equalTo(2));
    }
}
