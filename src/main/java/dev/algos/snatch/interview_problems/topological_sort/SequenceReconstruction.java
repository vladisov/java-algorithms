package dev.algos.snatch.interview_problems.topological_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3]]
 * <p>
 * Output:
 * false
 * <p>
 * Explanation:
 * [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
 * Example 2:
 * <p>
 * Input:
 * org: [1,2,3], seqs: [[1,2]]
 * <p>
 * Output:
 * false
 * <p>
 * Explanation:
 * The reconstructed sequence can only be [1,2].
 * Example 3:
 * <p>
 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 * <p>
 * Output:
 * true
 * <p>
 * Explanation:
 * The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 * Example 4:
 * <p>
 * Input:
 * org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 * <p>
 * Output:
 * true
 */
public class SequenceReconstruction {

    /**
     * Time O(V + N) - V - number of distinct numbers
     * Since, at most, each pair of numbers can give us one rule, we can conclude that the upper bound for the rules is O(N) where ‘N’
     * is the count of numbers in all sequences. So, we can say that the time complexity of our algorithm is O(V+N)
     * Space O(V + N)
     */
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.isEmpty()) return false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (var seq : seqs) {
            if (seq.isEmpty()) continue;
            map.putIfAbsent(seq.get(0), new ArrayList<>());
            for (int i = 1; i < seq.size(); i++) {
                int prev = seq.get(i - 1);
                int curr = seq.get(i);
                if (prev == curr) return false;

                map.putIfAbsent(curr, new ArrayList<>());
                map.get(prev).add(curr);
                indegree.put(curr, indegree.getOrDefault(curr, 0) + 1);
            }
        }
        if (map.size() != org.length) return false;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int num : map.keySet()) {
            if (indegree.get(num) == null) {
                queue.add(num);
            }
        }
        int count = 0, index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1 || queue.peek() != org[index++]) {
                return false;
            }
            count++;
            int num = queue.poll();
            if (map.containsKey(num)) {
                for (int adj : map.get(num)) {
                    indegree.put(adj, indegree.get(adj) - 1);
                    if (indegree.get(adj) == 0) {
                        queue.add(adj);
                    }
                }
            }
        }
        return count == org.length;
    }
}
