package dev.algos.snatch.interview_problems.fast_slow_pointers;

import java.util.HashSet;
import java.util.Set;

/**
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’.
 * All other (not-happy) numbers will never reach ‘1’.
 * Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
 * <p>
 * Input: 23
 * Output: true (23 is a happy number)
 * <p>
 * Input: 12
 * Output: false (12 is not a happy number)
 */
public class HappyNumber {

    public boolean find(int num) {
        return find(String.valueOf(num), new HashSet<>());
    }

    private boolean find(String str, Set<Integer> visited) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            int val = c - '0';
            sum += val * val;
        }
        if (sum == 1) {
            return true;
        } else if (visited.contains(sum)) {
            return false;
        }
        visited.add(sum);
        return find(String.valueOf(sum), visited);
    }

    boolean findWithoutSpace(int num) {
        int fast = num;
        int slow = num;
        while (fast != 1) {
            fast = calculateNum(calculateNum(fast));
            slow = calculateNum(slow);
            if (fast == slow) {
                return false;
            }
        }
        return true;
    }

    private int calculateNum(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
