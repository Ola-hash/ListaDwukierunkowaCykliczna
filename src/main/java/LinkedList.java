public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(T data) {
        Node<T> node = new Node<T>(data);
        if (size == 0) {
            head = node;
            tail = node;
            node.setNext(head);
            node.setPrev(tail);
        } else {
            Node<T> newNode = head;
            head.setNext(node);

        }
        size++;
    }

}
