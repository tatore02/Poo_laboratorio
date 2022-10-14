import org.junit.Assert;
import org.junit.Test;

public class InfectedTest {

    @Test
    public void infectedTest(){
        Infected infetti = new Infected("Covid",100);
        Assert.assertEquals("Covid",infetti.getDisease());
        Assert.assertEquals(100,infetti.getNumberOfInfected());
    }

    @Test
    public void updateInfectTest(){
        Infected infetti = new Infected("Covid");
        infetti.addInfected(10);
        Assert.assertEquals(10,infetti.getNumberOfInfected());
    }

    @Test
    public void updateInfectByRtTest(){
        Infected infetti = new Infected("Covid",100);
        infetti.updateInfectedByRt(5);
        Assert.assertEquals(500,infetti.getNumberOfInfected());
    }
}