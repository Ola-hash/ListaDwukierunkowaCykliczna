import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
    LinkedList<Integer> linkedList = new LinkedList<>();

    @Test
    public void shouldReturnTheCorrectFirstElement() throws LinkedListException {
        linkedList.addFirst(2);
        linkedList.add(3, 1);
        linkedList.add(4, 2);
        Integer expectedValue = linkedList.get(1).getData();
        Integer correctValue = 3;
        Assert.assertEquals(expectedValue, correctValue);
    }

    @Test
    public void shouldReturnTheCorrectSize() {
        linkedList.addFirst(2);
        Assert.assertEquals(1, linkedList.getSize());
    }

}
