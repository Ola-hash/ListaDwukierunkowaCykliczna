public class Main {
    public static void main(String[] args) throws LinkedListException {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(4);
        linkedList.add(2, 1);
        linkedList.add(3, 2);
        linkedList.add(3, 3);
        linkedList.add(5, 4);
        System.out.println(linkedList.getTail().getData());
    }
}
