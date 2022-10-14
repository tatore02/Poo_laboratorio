import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {
  @Test
    public void buyCanTest(){
    VendingMachine test = new VendingMachine(10);
    test.takeCan();
    Assert.assertEquals(9,test.getNumberOfCans());
    Assert.assertEquals(1,test.getNumberOfTokens());
  }

  @Test
  public void addCansTest(){
    VendingMachine test = new VendingMachine();
    test.addCans(12);
    Assert.assertEquals(12,test.getNumberOfCans());
  }

  @Test
  public void TakeMoney(){
    VendingMachine test = new VendingMachine(5);
    test.takeCan();
    test.takeCan();
    test.takeCan();
    Assert.assertEquals(2,test.getNumberOfCans());
    Assert.assertEquals(3,test.getNumberOfTokens());
    test.takeTokens();
    Assert.assertEquals(0,test.getNumberOfTokens());
  }
}