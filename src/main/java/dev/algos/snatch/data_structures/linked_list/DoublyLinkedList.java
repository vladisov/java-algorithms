package dev.algos.snatch.data_structures.linked_list;

public class DoublyLinkedList<T> {
    public class DoublyListNode<T> {
        T value;
        DoublyListNode<T> next;
        DoublyListNode<T> prev;

        public DoublyListNode(T value) {
            this.value = value;
        }
    }


}
