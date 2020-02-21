package dev.algos.snatch.data_structures.tree;

import java.util.Comparator;

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private Comparator<? super T> comparator;

    public BinarySearchTree(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public boolean search(T value) {
        if (isEmpty()) return false;
        var current = root;
        while (current != null) {
            var left = current.left;
            var right = current.right;
            if (this.comparator.compare(value, current.value) == 0) {
                return true;
            } else if (this.comparator.compare(value, current.value) > 0) {
                current = right;
            } else {
                current = left;
            }
        }
        return false;
    }

    /*
    Three cases of deletion:
    1. node is leaf
    2. node has one child
    3. node has two children
    */
    public boolean delete(T value) {
        if (isEmpty()) return false;

        var current = root;
        TreeNode<T> parent = null;
        while (current != null && current.value != value) {
            parent = current;
            if (this.comparator.compare(value, current.value) > 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        if (current == null) {
            return false;
        }

        // node to delete is leaf
        if (current.isLeaf()) {
            if (current.value == root.value) {
                root = null;
            } else if (this.comparator.compare(value, parent.value) > 0) {
                parent.right = null;
            } else {
                parent.left = null;
            }
            return true;
        }

        // node has two children
        if (current.left != null && current.right != null) {
            //find inorder successor and replace
            TreeNode<T> successor = findInOrderSuccessor(current);
            T tmp = successor.value;
            delete(tmp);
            current.value = tmp;
            return true;
        }

        //node has one child
        TreeNode<T> child;
        if (current.left != null) {
            child = current.left;
        } else {
            child = current.right;
        }

        if (current.value == root.value) {
            root = child;
        } else if (this.comparator.compare(value, parent.value) > 0) {
            parent.right = child;
        } else {
            parent.left = child;
        }
        return true;
    }

    private TreeNode<T> findInOrderSuccessor(TreeNode<T> node) {
        if (node == null || node.right == null) return null;
        var current = node.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean add(T value) {
        if (isEmpty()) {
            root = new TreeNode<>(value);
            return true;
        }
        var current = root;

        while (current != null) {
            var left = current.left;
            var right = current.right;

            if (this.comparator.compare(value, current.value) > 0) {
                if (right == null) {
                    current.right = new TreeNode<>(value);
                    return true;
                } else {
                    current = right;
                }
            } else if (this.comparator.compare(value, current.value) < 0) {
                if (left == null) {
                    current.left = new TreeNode<>(value);
                    return true;
                } else {
                    current = left;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public String printPreOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (root != null)
            root.printPreOrder(sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public String printInOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (root != null)
            root.printInOrder(sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public String printPostOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (root != null)
            root.printPostOrder(sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    static class TreeNode<T> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T value) {
            this.value = value;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }

        void printPreOrder(StringBuilder sb) {
            sb.append(value).append(",");
            if (left != null) {
                left.printInOrder(sb);
            }
            if (right != null) {
                right.printInOrder(sb);
            }
        }

        void printInOrder(StringBuilder sb) {
            if (left != null) {
                left.printInOrder(sb);
            }
            sb.append(value).append(",");
            if (right != null) {
                right.printInOrder(sb);
            }
        }

        public void printPostOrder(StringBuilder sb) {
            if (left != null) {
                left.printInOrder(sb);
            }
            if (right != null) {
                right.printInOrder(sb);
            }
            sb.append(value).append(",");
        }
    }
}
