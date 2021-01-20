import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
    LinkedList<Integer> linkedList = new LinkedList<>();

    @Test
    public void shouldReturnTheCorrectFirstElement() {

        linkedList.addFirst(2);
        linkedList.add(3, 1);
        linkedList.add(4, 2);

        Integer expectedValue = 3;
      //  Assert.assertEquals(expectedValue, correcttValue);
    }

    @Test
    public void shouldReturnTheCorrectSize() {
        linkedList.addFirst(2);
        Assert.assertEquals(1, linkedList.getSize());
    }

    @Test
    public void shouldReturn() {
        linkedList.addFirst(4);
        linkedList.addFirst(3);
        linkedList.addFirst(5);
        linkedList.remove(0);
        Assert.assertEquals(2, linkedList.getSize());
    }

}
