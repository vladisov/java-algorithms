package dev.algos.snatch.interview_problems.tree_bfs;

public class QuadTree {

    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length, grid.length);
    }

    private Node helper(int[][] grid, int startRow, int startCol, int endRow, int endCol) {
        Node root = new Node(true, false);
        if (isLeaf(grid, startRow, startCol, endRow, endCol)) {
            root.isLeaf = true;
            root.val = grid[startRow][startCol] == 1;
        } else {
            int colDiv = startCol + (endCol - startCol) / 2;
            int rowDiv = startRow + (endRow - startRow) / 2;
            root.topLeft = helper(grid, startRow, startCol, rowDiv, colDiv);
            root.topRight = helper(grid, startRow, colDiv, rowDiv, endCol);
            root.bottomLeft = helper(grid, rowDiv, startCol, endRow, colDiv);
            root.bottomRight = helper(grid, rowDiv, colDiv, endRow, endCol);
        }
        return root;
    }

    private boolean isLeaf(int[][] grid, int startRow, int startCol, int endRow, int endCol) {
        int dummy = grid[startRow][startCol];
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (grid[i][j] != dummy) {
                    return false;

                }
        }
        return true;
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
