public class Main {
    public static void main(String[] args) throws LinkedListException {
        LinkedList<Integer> linkedList = new LinkedList<>();
        try {
            linkedList.add(2, 0);
            linkedList.add(4, 1);
            linkedList.add(8, 2);
            linkedList.add(5, 3);
            linkedList.add(6, 4);
            System.out.println(linkedList.printLinkedList());
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }
    }
}
