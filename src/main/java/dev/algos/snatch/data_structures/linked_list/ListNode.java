package dev.algos.snatch.data_structures.linked_list;

public class ListNode<T> {
    public T value;
    public ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        while (next != null) {
            sb.append(",");
            sb.append(next.value);
            next = next.next;
        }
        return sb.toString();
    }
}
