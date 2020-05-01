package dev.algos.snatch.interview_problems.dp;

public class StoneGame {

    public boolean stoneGame(int[] piles) {
        int start = 0, end = piles.length - 1;
        return stoneGameRec(piles, start, end, 0, 0, true);
    }

    private boolean stoneGameRec(int[] piles, int start, int end, int totalA, int totalB, boolean first) {
        if (end < start) {
            return totalA > totalB;
        }

        boolean b1, b2;
        if (first) {
            b1 = stoneGameRec(piles, start + 1, end, totalA + piles[start], totalB, !first);
            b2 = stoneGameRec(piles, start, end - 1, totalA + piles[end], totalB, !first);
        } else {
            b1 = stoneGameRec(piles, start + 1, end, totalA, totalB + piles[start], !first);
            b2 = stoneGameRec(piles, start, end - 1, totalA, totalB + piles[end], !first);
        }
        return b1 || b2;
    }
}
