package dev.algos.snatch.interview_problems.top_k;

import java.io.File;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the kth largest file in the given a path of a directory.
 * <p>
 * For example, if the given path is /home/Documents ,
 * it can contains multiple files and directories inside. Say abc.txt, directory1, file2.txt...
 * You have to traverse each directory and return the kth largest file.
 */
public class FindKLargestFile {

    /**
     * Time O(nlogk) where n is number of nodes in a tree
     * Space O(h)
     */
    File findKLargestFile(String path, int k) {
        PriorityQueue<File> minHeap = new PriorityQueue<>(Comparator.comparingLong(File::length));
        File file = new File(path);
        parsePath(file, k, minHeap);
        return minHeap.poll();
    }

    void parsePath(File root, int k, PriorityQueue<File> minHeap) {
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    parsePath(file, k, minHeap);
                } else {
                    minHeap.add(file);
                    if (minHeap.size() > k) {
                        minHeap.poll();
                    }
                }
            }
        }
    }
}
