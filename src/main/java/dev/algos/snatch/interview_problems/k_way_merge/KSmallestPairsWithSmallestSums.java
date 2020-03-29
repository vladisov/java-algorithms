package dev.algos.snatch.interview_problems.k_way_merge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class KSmallestPairsWithSmallestSums {


    /**
     * Time complexity O((n+m*n)*logk) where k - total number of elements, n - size of first array, m - second
     * Space O(K)
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) {
            return List.of();
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            return (nums1[a.index1] + nums2[a.index2]) - (nums1[b.index1] + nums2[b.index2]);
        });
        minHeap.add(new Pair(0, 0));
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        while (!minHeap.isEmpty()) {
            Pair curr = minHeap.poll();
            result.add(List.of(nums1[curr.index1], nums2[curr.index2]));
            if (curr.index2 < nums2.length - 1) {
                if (!seen.contains(List.of(curr.index1, curr.index2 + 1))) {
                    minHeap.add(new Pair(curr.index1, curr.index2 + 1));
                    seen.add(List.of(curr.index1, curr.index2 + 1));
                }
            }
            if (curr.index1 < nums1.length - 1) {
                if (!seen.contains(List.of(curr.index1 + 1, curr.index2))) {
                    minHeap.add(new Pair(curr.index1 + 1, curr.index2));
                    seen.add(List.of(curr.index1 + 1, curr.index2));
                }
            }

            if (result.size() == k) {
                return result;
            }
        }

        return result;
    }


    public List<int[]> kSmallestPairsDiscuss(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int m = nums1.length, n = nums2.length;
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) return res;

        for (int j = 0; j <= n - 1; j++) {
            pq.offer(new Tuple(0, j, nums1[0] + nums2[j]));
        }

        for (int i = 0; i < Math.min(k, m * n); i++) {
            Tuple t = pq.poll();
            res.add(new int[]{nums1[t.x], nums2[t.y]});
            if (t.x == m - 1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
        }
        return res;
    }

    static class Pair {
        int index1;
        int index2;

        public Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class Tuple implements Comparable<Tuple> {
        int x, y, val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }
}
