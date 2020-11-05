package dev.algos.snatch.data_structures.segment_tree;

interface SegmentTree {

    /**
     * Update the value to <tt>val</tt> on index <tt>i</tt>.
     *
     * @param i   index to update
     * @param val value to set
     */
    void update(int i, int val);

    /**
     * To get the result of the range.
     *
     * @param rangeStart range left boundary, inclusive
     * @param rangeEnd   range right boundary, inclusive
     * @return result of the range, like sum, minimum value.
     */
    int get(int rangeStart, int rangeEnd);
}
