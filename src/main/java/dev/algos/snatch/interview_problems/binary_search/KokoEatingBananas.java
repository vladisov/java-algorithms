package dev.algos.snatch.interview_problems.binary_search;

/**
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * <p>
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * Example 2:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * Example 3:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 */
public class KokoEatingBananas {

    /**
     * Time O(N + NlogM)
     * Space O(1)
     */
    public int minEatingSpeed(int[] piles, int H) {
        int max = findMax(piles);
        int lo = findMinStart(piles, H, max), hi = max + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canEat(mid, piles, H)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    //not really needed, small optimization
    private int findMinStart(int[] piles, int H, int max) {
        int len = piles.length - 1;
        int hoursLeft = H - len;
        return max / hoursLeft + (max % hoursLeft == 0 ? 0 : 1);
    }

    private int findMax(int[] piles) {
        int max = 0;
        for (int num : piles) {
            max = Math.max(num, max);
        }
        return max;
    }

    public boolean canEat(int k, int[] piles, int H) {
        for (int pile : piles) {
            int hours = pile / k + (pile % k == 0 ? 0 : 1);
            H -= hours;
            if (H < 0) return false;
        }
        return true;
    }
}
