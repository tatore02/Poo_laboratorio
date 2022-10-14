import org.junit.Assert;
import org.junit.Test;

public class LockerTest {
    @Test
    public void lockTest(){
        Locker test = new Locker();
        test.lock();
        Assert.assertEquals(false,test.isOpen());
    }

    @Test
    public void unlockTest(){
        Locker test = new Locker();
        test.newComb("AAA");
        Assert.assertTrue(test.isOpen());
        test.lock();
        Assert.assertFalse(test.isOpen());
        test.unlock("AAA");
        Assert.assertTrue(test.isOpen());
    }

    @Test
    public void unlockTest2(){
        Locker test = new Locker();
        test.newComb("AAA");
        test.lock();
        Assert.assertFalse(test.isOpen());
        test.unlock("BBB");
        Assert.assertFalse(test.isOpen());
    }
}