package dev.algos.snatch.data_structures.linked_list;

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
            throw new IllegalArgumentException(String.format("Node %s has not been found in the list", previous.toString()));
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

    public boolean remove(int index) {
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        ListNode<T> temp = head;
        System.out.print("List : ");
        while (temp.next != null) {
            System.out.print(temp.value.toString() + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.value.toString() + " -> null");
    }
}
