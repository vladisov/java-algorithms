package dev.algos.snatch.interview_problems.top_k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].
 * Rearrange the barcodes so that no two adjacent barcodes are equal.  You may return any answer, and it is guaranteed an answer exists.
 * <p>
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 * <p>
 * Example 1:
 * Input: [1,1,1,2,2,2]
 * Output: [2,1,2,1,2,1]
 * Example 2:
 * <p>
 * Input: [1,1,1,1,2,2,3,3]
 * Output: [1,3,1,3,2,1,2,1]
 */
public class DistantBarcodes {

    /**
     * Time Complexity O(N)
     * Space O(N)
     */
    /*
    [1,1,1,1,2,2,2,3,3,3]
    1 2 1 2 1 2 1 3
     */
    public int[] rearrangeBarcodesOptimized(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
            max = Math.max(max, map.get(barcode));
        }
        List[] buckets = new List[max + 1];
        for (var entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<Integer>();
            }
            buckets[freq].add(num);
        }

        int[] res = new int[barcodes.length];
        int index = 0;
        for (int i = max; i > 0; i--) {
            List<Integer> bucket = buckets[i];
            if (bucket == null) continue;
            for (int num : bucket) {
                int freq = i;
                while (freq > 0) {
                    res[index] = num;
                    index = index + 2 < res.length ? index + 2 : 1;
                    freq--;
                }
            }
        }
        return res;
    }

    /**
     * Time Complexity O(NlogN)
     * Space O(N)
     */
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());

        int[] res = new int[barcodes.length];
        int i = 0;
        while (!queue.isEmpty()) {
            int last = queue.poll();
            if (i > 0 && res[i - 1] == last) {
                int prev = queue.poll(); // guaranteed
                queue.add(last);
                last = prev;
            }
            res[i++] = last;
            map.put(last, map.get(last) - 1);
            if (map.get(last) == 0) {
                map.remove(last);
            } else {
                queue.add(last);
            }
        }
        return res;
    }
}
