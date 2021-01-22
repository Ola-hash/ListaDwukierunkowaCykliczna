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
            node.setNext(node);
            node.setPrev(node);
            head = node;
            tail = node;
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

    public void removeFirst() throws LinkedListException {
        if (size == 0) {
            throw new LinkedListException("Lista jest pusta");
        } else {
            head = head.getNext();
            tail.setNext(head);
            size--;
        }
    }

    public void removeLast() throws LinkedListException {
        if (size == 0) {
            throw new LinkedListException("Lista jest pusta");
        } else {
            tail = tail.getPrev();
            tail.setNext(head);
            head.setPrev(tail);
            tail.setNext(head);
            size--;
        }
    }

    public void remove(int index) throws LinkedListException {
        if (index > size - 1 || index < 0) {
            throw new LinkedListException(index + " - niepoprany indeks");
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        } else if (index < size / 2) {
            removeFromTheHead(index);
        } else {
            removeFromTheTail(index);
        }
        size--;
    }

    public void add(T value, int position) throws LinkedListException {
        if (position < 0 || position > size) {
            throw new LinkedListException(position + " - niepoprawny indeks");
        }
        if (position == 0) {
            addFirst(value);
            return;
        }
        if (position == size) {
            addLast(value);
            return;

        } else if (position < size / 2) {
            Node<T> node = head;
            for (int i = 0; i < position; i++) {
                node = node.getNext();
            }
            Node<T> newNode = new Node<T>(value);
            Node<T> prev = node.getPrev();
            newNode.setPrev(prev);
            prev.setNext(newNode);
            node.setPrev(newNode);
            newNode.setNext(node);
        } else {
            Node<T> node = tail;
            for (int i = size - 1; i > position; i--) {
                node = node.getPrev();
            }
            Node<T> newNode = new Node<T>(value);
            Node<T> prev = node.getPrev();
            newNode.setPrev(prev);
            prev.setNext(newNode);
            newNode.setNext(node);
            node.setPrev(newNode);
        }
        size++;
    }

    public void removeFromTheHead(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        Node<T> next = node.getNext();
        Node<T> prev = node.getPrev();
        next.setPrev(prev);
        prev.setNext(next);
    }

    public void removeFromTheTail(int index) {
        Node<T> node = tail;
        for (int i = size - 1; i > index; i--) {
            node = node.getPrev();
        }
        Node<T> next = node.getNext();
        Node<T> prev = node.getPrev();
        next.setPrev(prev);
        prev.setNext(next);
    }

    public Node<T> get(int index) throws LinkedListException {
        if (index < 0 || index > size) {
            throw new LinkedListException(index + " - podanego indeksu nie ma w liscie");
        } else if (index <= size / 2) {
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node;
        } else {
            Node<T> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.getPrev();
            }
            return node;
        }
    }

    public void print() {
        if (size == 0) {
            System.out.println("Lista jest pusta");
        } else {
            Node<T> node = head;
            while (node.getNext() != head) {
                System.out.println(node.getData());
                node = node.getNext();
            }
            System.out.println(node.getData());
        }
    }

    public String printLinkedList() {
        StringBuilder result = new StringBuilder();
        if (size == 0) {
            System.out.println("Lista jest pusta");
        } else {
            Node<T> node = head;
            while (node.getNext() != head) {
                result.append(node.getData()).append(" ");
                node = node.getNext();
            }
            result.append(node.getData());
        }
        return result.toString();
    }
}