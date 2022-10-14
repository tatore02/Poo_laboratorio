import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstAndLastWordTest {
    @Test
    public void printFirstAndLastWordTest() {
        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("a");
        list.add("B");
        list.add("d");

        FirstAndLastWord list2 = new FirstAndLastWord(list);
        list2.sort();
        Assert.assertEquals("B", list2.getFirst());
        Assert.assertEquals("d", list2.getLast());
    }

    @Test
    public void printFirstAndLastWordIgnoreCaseTest() {
        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("a");
        list.add("B");
        list.add("d");

        FirstAndLastWord list2 = new FirstAndLastWord(list);
        list2.sortIgnoreCase();
        Assert.assertEquals("a", list2.getFirst());
        Assert.assertEquals("d", list2.getLast());
    }
}