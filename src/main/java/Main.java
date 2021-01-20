public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2, 0);
        Node<Integer> node = linkedList.getHead();
        linkedList.add(3, 1);
        linkedList.add(3, 2);

        System.out.println(linkedList.getNode(2).getData());
    }
}
