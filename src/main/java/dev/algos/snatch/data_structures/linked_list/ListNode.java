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
        var nextNode = this.next;
        while (nextNode != null) {
            sb.append(",");
            sb.append(nextNode.value);
            nextNode = nextNode.next;
        }
        return sb.toString();
    }
}
