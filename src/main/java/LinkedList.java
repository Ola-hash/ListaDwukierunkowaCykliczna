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
            head.setNext(tail);
            head.setPrev(tail);
            tail.setNext(head);
            tail.setPrev(head);
        } else {
            node.setNext(head);
            node.setPrev(tail);
            tail.setNext(node);
            head.setPrev(node);
            head = node;
        }
        size++;
    }

    public void addLast(T data) {
        if (size == 0) {
            addFirst(data);
        } else {
            Node<T> node = new Node<T>(data);
            node.setPrev(tail);
            node.setNext(head);
            tail.setNext(node);
            head.setPrev(node);
            tail = node;
            size++;
        }
    }
}
