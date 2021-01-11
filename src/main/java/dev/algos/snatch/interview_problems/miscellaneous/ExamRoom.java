package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.TreeSet;

class ExamRoom {

    int n;
    TreeSet<Integer> set;

    public ExamRoom(int N) {
        this.n = N;
        this.set = new TreeSet<>();
    }

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.leave(0);
        examRoom.leave(4);
        examRoom.seat();
    }

    public int seat() {
        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }
        if (set.size() == 1 && set.size() < n) {
            set.add(n - 1);
            return n - 1;
        }
        if (set.size() == n) return -1;

        int firstLen = -1, lastLen = -1;
        if (set.first() != 0) {
            firstLen = set.first();
        }
        if (set.last() != n - 1) {
            lastLen = n - set.last() - 1;
        }
        Integer prev = null;
        int maxLen = 0, maxIndex = -1;
        for (int seat : set) {
            if (prev != null) {
                int len = seat - prev;
                if (len / 2 > maxLen) {
                    maxLen = len / 2;
                    maxIndex = prev;
                }
            }
            prev = seat;
        }
        if (firstLen >= maxLen) {
            set.add(0);
            return 0;
        }
        if (lastLen > maxLen) {
            set.add(n - 1);
            return n - 1;
        }
        set.add(maxIndex + maxLen);
        return maxIndex + maxLen;
    }

    public void leave(int p) {
        set.remove(p);
    }
}
