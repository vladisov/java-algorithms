package dev.algos.snatch.interview_problems.union_find;

import java.util.Arrays;
import java.util.Comparator;

/**
 * In a social group, there are N people, with unique integer ids from 0 to N-1.
 * <p>
 * We have a list of logs, where each logs[i] = [timestamp, id_A, id_B] contains a non-negative integer timestamp, and the ids of two different people.
 * <p>
 * Each log represents the time in which two different people became friends.  Friendship is symmetric: if A is friends with B, then B is friends with A.
 * <p>
 * Let's say that person A is acquainted with person B if A is friends with B, or A is a friend of someone acquainted with B.
 * <p>
 * Return the earliest time for which every person became acquainted with every other person. Return -1 if there is no such earliest time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
 * Output: 20190301
 * Explanation:
 * The first event occurs at timestamp = 20190101 and after 0 and 1 become friends we have the following friendship groups [0,1], [2], [3], [4], [5].
 * The second event occurs at timestamp = 20190104 and after 3 and 4 become friends we have the following friendship groups [0,1], [2], [3,4], [5].
 * The third event occurs at timestamp = 20190107 and after 2 and 3 become friends we have the following friendship groups [0,1], [2,3,4], [5].
 * The fourth event occurs at timestamp = 20190211 and after 1 and 5 become friends we have the following friendship groups [0,1,5], [2,3,4].
 * The fifth event occurs at timestamp = 20190224 and as 2 and 4 are already friend anything happens.
 * The sixth event occurs at timestamp = 20190301 and after 0 and 3 become friends we have that all become friends.
 */
public class EarliestMomentWhenEveryoneFriend {

    /**
     * Time O(NlogN)
     * Space O(N)
     */
    public int earliestFriend(int[][] logs, int n) {
        if (logs.length == 0 || n == 0) return -1;
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        UnionFind uf = new UnionFind(n);
        for (int[] log : logs) {
            int time = log[0];
            uf.union(log[1], log[2]);
            if (uf.getSize() == 1) {
                return time;
            }
        }
        return -1;
    }

    static class UnionFind {
        int[] arr;
        int size;

        public UnionFind(int n) {
            this.arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            size = n;
        }

        int root(int i) {
            while (i != arr[i]) {
                arr[i] = arr[arr[i]];
                i = arr[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p = root(i);
            int q = root(j);
            if (p == q) return;
            size--;
            arr[p] = q;
        }

        int getSize() {
            return size;
        }
    }
}
