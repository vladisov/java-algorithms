package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.Arrays;

/**
 * Commander Lambda's minions are upset! They're given the worst jobs on the whole space station, and some of them are starting to complain that even those worst jobs are being allocated unfairly.
 * If you can fix this problem, it'll prove your chops to Commander Lambda so you can get promoted!
 * Minions' tasks are assigned by putting their ID numbers into a list, one time for each day they'll work that task.
 * As shifts are planned well in advance, the lists for each task will contain up to 99 integers.
 * When a minion is scheduled for the same task too many times, they'll complain about it until they're taken off the task completely.
 * Some tasks are worse than others, so the number of scheduled assignments before a minion will refuse to do a task varies depending on the task.
 * You figure you can speed things up by automating the removal of the minions who have been assigned a task too many times before they even get a chance to start complaining.
 * Write a function called solution(data, n) that takes in a list of less than 100 integers and a number n,
 * and returns that same list but with all of the numbers that occur more than n times removed entirely.
 * The returned list should retain the same ordering as the original list - you don't want to mix up those carefully-planned shift rotations!
 * For instance, if data was [5, 10, 15, 10, 7] and n was 1, solution(data, n)
 * would return the list [5, 15, 7] because 10 occurs twice, and thus was removed from the list entirely.
 */
public class MinionsFBL1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3}, 0)));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{7, 1, 2, 2, 1, 1, 3, 4, 5, 1, 5}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5}, 2)));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5}, 3)));
        System.out.println(Arrays.toString(solution(new int[]{5, 10, 15, 10, 7}, 1)));
    }


    /**
     * Time O(N^2)
     * Space O(1)
     */
    public static int[] solution(int[] data, int n) {
        if (n == 0) return new int[0];
        int[] d = new int[data.length];
        int k = 0;
        for (int i = 0; i < data.length; i++) {
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                if (data[i] == data[j]) {
                    count++;
                }
            }
            if (count <= n) {
                d[k] = data[i];
                k++;
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = d[i];
        }
        return result;
    }
}
