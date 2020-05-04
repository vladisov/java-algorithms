package dev.algos.snatch.interview_problems.dp.bitmask;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a m * n matrix seats  that represent seats distributions in a classroom.
 * If a seat is broken, it is denoted by '#' character otherwise it is denoted by a '.' character.
 * <p>
 * Students can see the answers of those sitting next to the left, right,
 * upper left and upper right, but he cannot see the answers of the student sitting directly in front or behind him.
 * Return the maximum number of students that can take the exam together without any cheating being possible..
 * <p>
 * Students must be placed in seats in good condition.
 * <p>
 * Input: seats =
 * [["#",".","#","#",".","#"],
 * [".","#","#","#","#","."],
 * ["#",".","#","#",".","#"]]
 * Output: 4
 * Explanation: Teacher can place 4 students in available seats so they don't cheat on the exam.
 */
public class MaximumStudentsTakingExam {


    private int r, c;
    private int[][] memo;
    private List<Integer> masks;

    /**
     * Time Complexity O(N*2^M)
     * Space complexity O(N*2^M)
     */
    public int maxStudents(char[][] seats) {
        r = seats.length;
        c = seats[0].length;
        memo = new int[r][1 << c]; // 2^c
        for (int i = 0; i < r; i++) {
            Arrays.fill(memo[i], -1); //1111111111111111111->32bit
        }
        return getMax(seats, 0, 0);
    }

    private int getMax(char[][] seats, int curRow, int prevRowMask) {
        if (curRow == r) return 0;
        if (memo[curRow][prevRowMask] != -1) {
            return memo[curRow][prevRowMask];
        }
        masks = new LinkedList<>(); // reset the masks list for backtrack
        backtrack(seats[curRow], 0, prevRowMask, 0); // backtrack results store in masks list
        int res = 0;
        for (int m : masks) {
            res = Math.max(res, Integer.bitCount(m) + getMax(seats, curRow + 1, m)); //try to find best fit from next rows
        }
        memo[curRow][prevRowMask] = res;
        return res;
    }

    // this returns all combination of legal seat assignment for a given row based on previous row's mask
    /*
        example : #.##.#
        all combinations:
        010010
        010000
        000010
        000000
     */
    private void backtrack(char[] seats, int curr, int prevRowMask, int currRowMask) {
        if (curr == c) {
            masks.add(currRowMask);
            return;
        }

        // cur seat is taken, check if LEFT, UPPER LEFT and UPPER RIGHT positions are empty
        // currRowMask & (1 << (curr - 1))) == 0 - check is LEFT bit is set
        // prevRowMask & (1 << (curr - 1))) == 0 - check is UPPER LEFT bit is set
        // prevRowMask & (1 << (curr + 1))) == 0 - check is UPPER RIGHT bit is set
        /*
            example : #.##.#
            if currmask = 0010 and curr = 4 we check for index 4
            1 << (4 - 1) = 1000
            1 << (4 + 1) = 100000
            true and we set 010010

            OR
            prevMask = 010010
            curMask = ?00001
            1 << (5 - 1) = 10000 so prev is busy

            OR
            prevMask = 010010
            currMask = 000000
            1 << (0 + 1) = 000010 -> prev is busy
         */
        if (seats[curr] == '.'
                && (curr == 0 || (((currRowMask & (1 << (curr - 1))) == 0) && (prevRowMask & (1 << (curr - 1))) == 0))
                && (curr == c - 1 || ((prevRowMask & (1 << (curr + 1))) == 0))) {
            currRowMask |= (1 << curr); // to set curr bit
            backtrack(seats, curr + 1, prevRowMask, currRowMask);
            currRowMask ^= (1 << curr); // to unset curr bit back
        }

        // cur seat is not taken
        backtrack(seats, curr + 1, prevRowMask, currRowMask);
    }
}
