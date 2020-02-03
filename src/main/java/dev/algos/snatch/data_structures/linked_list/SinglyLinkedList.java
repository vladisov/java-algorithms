package dev.algos.snatch.data_structures.linked_list;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListNode<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void insertAtHead(T value) {
        ListNode<T> node = new ListNode<>(value);
        node.next = head;
        head = node;
        size++;
    }

    public void insertAtEnd(T value) {
        ListNode<T> node = new ListNode<>(value);
        if (head == null) {
            head = node;
        } else {
            var curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        size++;
    }

    public void insertAfter(T value, T previous) {
        if (isEmpty()) {
            insertAtEnd(value);
        }
        ListNode<T> node = new ListNode<>(value);
        var curr = head;
        while (curr.next != null && curr != previous) {
            curr = curr.next;
        }
        if (curr.next == null) {
            curr.next = node;
        } else {
            var next = curr.next;
            curr.next = node;
            node.next = next;
        }
    }

    public boolean remove(T value) {
        ListNode<T> curr = head, prev = null;
        while (curr != null) {
            if (curr.value.equals(value)) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public boolean remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        int i = 0;
        ListNode<T> curr = head, prev = null;
        while (curr != null) {
            if (i == index) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                break;
            }
            i++;
            prev = curr;
            curr = curr.next;
        }
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        var curr = head;
        int i = 0;
        while (curr != null) {
            if (i == index) {
                break;
            }
            i++;
            curr = curr.next;
        }
        return Objects.requireNonNull(curr).value;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("List is Empty!");
            return sb.toString();
        }

        ListNode<T> temp = head;
        while (temp.next != null) {
            sb.append(temp.value.toString())
                    .append(" -> ");
            temp = temp.next;
        }
        return sb.append(temp.value.toString())
                .toString();
    }
}
