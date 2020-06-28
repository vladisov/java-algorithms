package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * In an infinite binary tree where every node has two children, the nodes are labelled in row order.
 * <p>
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
 * <p>
 * <p>
 * <p>
 * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
 */
public class PathInZigZagLabeledBinaryTree {

    /**
     * Time O(Height)
     * Space O(Height)
     */
    public List<Integer> pathInZigZagTree(int label) {
        return helper(label);
    }

    private List<Integer> helper(int label) {
        List<Integer> result = new ArrayList<>();
        result.add(label);
        int row = getRow(label);
        while (row != 1) {
            int position = getPosition(label, row);
            int parent = getParent(position, label, row - 1);
            result.add(parent);
            label = parent;
            row--;
        }
        Collections.reverse(result);
        return result;
    }

    int getParent(int position, int currentLabel, int parentRow) {
        if (parentRow == 0) return 0;
        if (parentRow == 1) return 1;
        int parentPosition = position / 2;
        int prevRow = parentRow - 1;
        int start = 1 << prevRow;
        if (parentRow % 2 != 0) {
            return start + parentPosition;
        }
        int max = (1 << parentRow) - 1;
        return max - parentPosition;
    }

    int getPosition(int label, int row) {
        int max = (1 << row) - 1;
        if (row % 2 != 0) {
            int numsCount = 1 << (row - 1);
            int start = (max + 1) - numsCount;
            return label - start;
        } else {
            return max - label;
        }
    }

    int getRow(int label) {
        if (label == 0) return 0;
        return 32 - Integer.numberOfLeadingZeros(label);
    }
}
