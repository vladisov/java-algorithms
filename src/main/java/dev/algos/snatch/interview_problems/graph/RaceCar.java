package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)
 * <p>
 * Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).
 * <p>
 * When you get an instruction "A", your car does the following: position += speed, speed *= 2.
 * <p>
 * When you get an instruction "R", your car does the following: if your speed is positive then speed = -1 , otherwise speed = 1.  (Your position stays the same.)
 * <p>
 * For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.
 * <p>
 * Now for some target position, say the length of the shortest sequence of instructions to get there.
 * <p>
 * Example 1:
 * Input:
 * target = 3
 * Output: 2
 * Explanation:
 * The shortest instruction sequence is "AA".
 * Your position goes from 0->1->3.
 * Example 2:
 * Input:
 * target = 6
 * Output: 5
 * Explanation:
 * The shortest instruction sequence is "AAARA".
 * Your position goes from 0->1->3->7->7->6.
 */
public class RaceCar {

    /**
     * Time O(2^N)
     * Space O(N^2) ?
     */
    public int racecar(int target) {
        if (target == 0) return 0;
        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(1, 2));
        queue.add(new State(0, -1));
        int lvl = 0;
        Set<State> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            lvl++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State state = queue.poll();
                if (state.pos == target) {
                    return lvl;
                }
                State aState = new State(state.pos + state.speed, state.speed * 2);
                State bState = new State(state.pos, state.speed > 0 ? -1 : 1);
                // after each step we don't want to extra target, so we restrict by 2*target
                /*
                There are cases when it is desirable to go past the target and then come back. For example, target = 6,
                we could go 0 --> 1 --> 3 --> 7 --> 7 --> 6, which takes 5 instructions (AAARA).
                If you reverse before passing the target, it takes more than 5 instructions to get to the target.
                That said, we don't want to go too far past the target. The rule of thumb (I have not proved it rigorously though)
                is that we stay within some limit from the target, and this limit is set by the initial distance from the target, which is target.
                So from the point of view of the target, we want the car to stay in the range [0, 2 * target].
                This is the primary optimization for the BFS solution.

                 */
                if (Math.abs(state.pos - target) <= target) {
                    if (!visited.contains(aState)) {
                        queue.add(aState);
                        visited.add(aState);
                    }
                    if (!visited.contains(bState)) {
                        queue.add(bState);
                        visited.add(bState);
                    }
                }
            }
        }
        return lvl;
    }

    static class State {
        int pos;
        int speed;

        public State(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return pos == state.pos &&
                    speed == state.speed;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pos, speed);
        }
    }
}
