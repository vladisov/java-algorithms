package dev.algos.snatch.interview_problems.segment_tree;

public class RangeSumQueryMutable {
    private final SegmentTree tree;

    public RangeSumQueryMutable(int[] nums) {
        tree = new SegmentTree(nums);
    }

    /**
     * Time O(logN)
     */
    public void update(int i, int val) {
        tree.update(i, val);
    }


    /**
     * Time O(logN)
     */
    public int sumRange(int i, int j) {
        return tree.get(i, j);
    }

    static class SegmentTree {
        private int[] arr;
        private int[] tree;

        public SegmentTree(int[] arr) {
            if (arr.length == 0) return;
            int n = arr.length;
            this.arr = arr;
            int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));
            tree = new int[2 * (1 << height) - 1];
            construct(0, n - 1, 0);
        }

        int construct(int lo, int hi, int i) {
            if (lo == hi) {
                tree[i] = arr[lo];
                return arr[lo];
            }

            int mid = lo + (hi - lo) / 2;
            tree[i] = construct(lo, mid, 2 * i + 1) + construct(mid + 1, hi, 2 * i + 2);
            return tree[i];
        }

        int get(int rangeLow, int rangeHigh) {
            return get(0, arr.length - 1, rangeLow, rangeHigh, 0);
        }

        void update(int i, int val) {
            if (i < 0 || i > arr.length - 1) {
                return;
            }
            int diff = val - arr[i];
            arr[i] = val;
            update(0, arr.length - 1, i, diff, 0);
        }

        void update(int lo, int hi, int index, int diff, int i) {
            if (index < lo || index > hi) {
                return;
            }
            tree[i] += diff;
            if (hi != lo) {
                int mid = lo + (hi - lo) / 2;
                update(lo, mid, index, diff, 2 * i + 1);
                update(mid + 1, hi, index, diff, 2 * i + 2);
            }

        }

        private int get(int lo, int hi, int rangeLow, int rangeHigh, int i) {
            if (rangeLow <= lo && hi <= rangeHigh) {
                return tree[i];
            }
            if (hi < rangeLow || lo > rangeHigh) {
                return 0;
            }
            int mid = lo + (hi - lo) / 2;
            return get(lo, mid, rangeLow, rangeHigh, 2 * i + 1) + get(mid + 1, hi, rangeLow, rangeHigh, 2 * i + 2);
        }
    }
}
