public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private Node<T> node;


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

    public void removeFirst() {
        if (size == 0) {
            System.out.println("Lista jest pusta");
        } else {
            head = head.getNext();
            tail.setNext(head);
            size--;
        }
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("Lista jest pusta");
        } else {
            tail = tail.getPrev();
            tail.setNext(head);
            head.setPrev(tail);
            tail.setNext(head);
            size--;
        }
    }

    public boolean remove(int index) throws LinkedListException {
        if (index > size - 1 && index < 0) {
            throw new LinkedListException("Niepoprawny index");
        }
        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == size - 1) {
            removeLast();
            return true;
        } else if (index < size / 2) {
            addFromTheHead(index);
        } else {
            addFromTheTail(index);
        }
        size--;
        return true;
    }

    public boolean add(T value, int position) throws LinkedListException {
        if (position < 0) {
            throw new LinkedListException("Niepoprawny index");
        }
        if (position == size - 1) {
            addLast(value);
            return true;
        }
        if (position == 0) {
            addFirst(value);
            return true;
        } else if (position < size / 2) {
            Node<T> node = head;
            for (int i = 0; i < position; i++) {
                node = node.getNext();
            }
            Node<T> newNode = new Node<T>(value);
            Node<T> prev = node.getPrev();
            newNode.setNext(node);
            newNode.setPrev(prev);
            prev.setNext(newNode);
            node.setPrev(newNode);

        } else {
            Node<T> node = tail;
            for (int i = size - 1; i > position; i--) {
                node = node.getPrev();
            }
            Node<T> newNode = new Node<T>(value);
            newNode.setNext(node);
            Node<T> prev = node.getPrev();
            newNode.setPrev(prev);
            prev.setNext(newNode);
            node.setPrev(newNode);
        }
        size++;
        return true;
    }

    public void addFromTheHead(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        Node<T> next = node.getNext();
        Node<T> prev = node.getPrev();
        next.setPrev(prev);
        prev.setNext(next);

    }

    public void addFromTheTail(int index) {
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
        if (index < 0 || index > size - 1) {
            throw new LinkedListException("Niepoprawny index");
        } else if (index < size / 2) {
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            Node<T> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.getPrev();
            }

        }
        return node;
    }


    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }


}