package dev.algos.snatch.interview_problems.topological_sort;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class TaskSchedulingOrdersTest {

    @Test
    void test() {
        TaskSchedulingOrders instance = new TaskSchedulingOrders();
        assertThat(instance.printOrders(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}}).toString(), equalTo("[[0, 1, 2]]"));
        assertThat(instance.printOrdersEducative(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}}).toString(), equalTo("[[0, 1, 2]]"));
        assertThat(instance.printOrders(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4},
                new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}}).toString(), equalTo("[[0, 1, 3, 2, 4, 5], [0, 1, 3, 2, 5, 4], [0, 1, 3, 4, 2, 5], [0, 1, 4, 3, 2, 5], [1, 0, 3, 2, 4, 5], [1, 0, 3, 2, 5, 4], [1, 0, 3, 4, 2, 5], [1, 0, 4, 3, 2, 5], [1, 3, 0, 2, 4, 5], [1, 3, 0, 2, 5, 4], [1, 3, 0, 4, 2, 5], [1, 3, 2, 0, 4, 5], [1, 3, 2, 0, 5, 4]]"));
        assertThat(instance.printOrdersEducative(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4},
                new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}}).toString(), equalTo("[[0, 1, 4, 3, 2, 5], [0, 1, 3, 4, 2, 5], [0, 1, 3, 2, 4, 5], [0, 1, 3, 2, 5, 4], [1, 0, 3, 4, 2, 5], [1, 0, 3, 2, 4, 5], [1, 0, 3, 2, 5, 4], [1, 0, 4, 3, 2, 5], [1, 3, 0, 2, 4, 5], [1, 3, 0, 2, 5, 4], [1, 3, 0, 4, 2, 5], [1, 3, 2, 0, 5, 4], [1, 3, 2, 0, 4, 5]]"));
    }
}
