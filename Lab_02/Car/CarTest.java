import org.junit.Assert;
import org.junit.Test;

public class CarTest {
    @Test
    public void addGasTest(){
        Car auto = new Car(2);
        auto.addGas(10);
        Assert.assertEquals(10,auto.getGas(),0);
    }

    @Test
    public void driveTest(){
        Car auto = new Car(2);
        auto.drive(15);
        Assert.assertEquals(-30,auto.getGas(),0);
    }
}