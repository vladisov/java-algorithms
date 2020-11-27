package dev.algos.snatch.data_structures.segment_tree;

public class SegmentTreeArray implements SegmentTree {

    private final int[] tree; // The array that stores segment tree nodes
    private final int[] values;

    /* Constructor to construct segment tree from given array. This
       constructor  allocates memory for segment tree and calls
       constructSTUtil() to  fill the allocated memory */
    public SegmentTreeArray(int[] arr) {
        int n = arr.length;
        //Height of segment tree
        int height = (int) (Math.ceil(Math.log(n) / Math.log(2))); // log2(n)
        //Maximum size of segment tree
        int max_size = 2 * (1 << height) - 1;
        tree = new int[max_size]; // Memory allocation
        construct(arr, 0, n - 1, 0);

        values = new int[arr.length];
        System.arraycopy(arr, 0, values, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree tree = new SegmentTreeArray(arr);
        System.out.println("Sum of values in  given range = " + tree.get(1, 3));
        // Update: set arr[1] = 10 and update corresponding segment
        // tree nodes
        tree.update(1, 10);
        // Find sum after the value is updated
        System.out.println("Updated sum of values in given range = " + tree.get(1, 3));
    }

    // A recursive function that constructs Segment Tree for array[lo..hi].
    // index is index of current node in segment tree st
    private int construct(int[] arr, int lo, int hi, int index) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (lo == hi) {
            tree[index] = arr[lo];
            return arr[lo];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(lo, hi);
        tree[index] = construct(arr, lo, mid, 2 * index + 1) +
                construct(arr, mid + 1, hi, 2 * index + 2);
        return tree[index];
    }

    private int getMid(int lo, int hi) {
        return lo + (hi - lo) / 2;
    }

    /*  A recursive function to get the sum of values in given range
        of the array.  The following are parameters for this function.

      tree    --> Pointer to segment tree
      index    --> Index of current node in the segment tree. Initially
                0 is passed as root is always at index 0
      lo & hi  --> Starting and ending indexes of the segment represented
                    by current node, i.e., st[index]
      rangeStart & rangeEnd  --> Starting and ending indexes of query range */
    private int getSum(int lo, int hi, int rangeStart, int rangeEnd, int index) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (rangeStart <= lo && rangeEnd >= hi) {
            return tree[index];
        }
        // If segment of this node is outside the given range
        if (hi < rangeStart || lo > rangeEnd) {
            return 0;
        }
        // If a part of this segment overlaps with the given range
        int mid = getMid(lo, hi);
        return getSum(lo, mid, rangeStart, rangeEnd, 2 * index + 1) +
                getSum(mid + 1, hi, rangeStart, rangeEnd, 2 * index + 2);
    }

    /* A recursive function to update the nodes which have the given
       index in their range. The following are parameters
        st, index, lo and hi are same as getSumUtil()
        i    --> index of the element to be updated. This index is in
                 input array.
       diff --> Value to be added to all nodes which have i in range */
    private void updateValueUtil(int lo, int hi, int i, int diff, int index) {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < lo || i > hi)
            return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        tree[index] = tree[index] + diff;
        if (hi != lo) {
            int mid = getMid(lo, hi);
            updateValueUtil(lo, mid, i, diff, 2 * index + 1);
            updateValueUtil(mid + 1, hi, i, diff, 2 * index + 2);
        }
    }

    @Override
    public void update(int index, int val) {
        // Check for erroneous input index
        if (index < 0 || index > values.length - 1) {
            System.out.println("Invalid Input");
            return;
        }
        // Get the difference between new value and old value
        int diff = val - values[index];
        values[index] = val;
        updateValueUtil(0, values.length - 1, index, diff, 0);
    }

    @Override
    public int get(int rangeStart, int rangeEnd) {
        if (rangeStart < 0 || rangeEnd > values.length - 1 || rangeStart > rangeEnd) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSum(0, values.length - 1, rangeStart, rangeEnd, 0);
    }
}
