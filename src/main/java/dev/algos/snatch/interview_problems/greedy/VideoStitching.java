package dev.algos.snatch.interview_problems.greedy;

import java.util.Arrays;

/**
 * You are given a series of video clips from a sporting event that lasted T seconds.
 * These video clips can be overlapping with each other and have varied lengths.
 * <p>
 * Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1].
 * We can cut these clips into segments freely: for example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
 * <p>
 * Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event ([0, T]).
 * If the task is impossible, return -1.
 */
public class VideoStitching {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        int[] arr = new int[T + 1];
        for (int[] clip : clips) {
            if (clip[0] > T) continue;
            int left = clip[0];
            arr[left] = Math.max(arr[left], clip[1]);
        }
        int end = 0, maxEnd = 0, count = 0;
        for (int i = 0; i <= T && end < T; end = maxEnd) {
            count++;
            while (i <= T && i <= end) {
                maxEnd = Math.max(maxEnd, arr[i++]);
            }
            if (maxEnd == end) return -1;
        }
        return count;
    }

    public int videoStitchingO1(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        int end = 0, maxEnd = 0, count = 0;
        if (clips[clips.length - 1][1] < T) return -1;
        //if end == T we're out
        for (int i = 0; i < clips.length && end < T; end = maxEnd) {
            count++;
            while (i < clips.length && clips[i][0] <= end) {
                maxEnd = Math.max(maxEnd, clips[i++][1]);
            }
            if (maxEnd == end) return -1;
        }
        return count;
    }
}
