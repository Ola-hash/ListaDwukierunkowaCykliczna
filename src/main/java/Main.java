public class Main {
    public static void main(String[] args) throws LinkedListException {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(2, 0);
        linkedList.add(3, 1);

        System.out.println(linkedList.get(1).getData());
    }
}
