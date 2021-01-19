public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(5);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(4);
        linkedList.addFirst(7);
        linkedList.remove(1);
        System.out.println(linkedList.getHead().getData());
        System.out.println(linkedList.getSize());
    }
}
