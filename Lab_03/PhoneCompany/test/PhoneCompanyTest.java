import org.junit.Assert;
import org.junit.Test;

public class PhoneCompanyTest {
    @Test
    public void findUserByCodeTest(){
        PhoneCompany p = new PhoneCompany(0.10,0.05,1);
        User r1 = new User(1,"Salvatore","Ruocco");
        User r2 = new User(2,"Lorenzo","Insigne");
        p.add(r1);
        Assert.assertEquals(r1,p.findUserByCode(1));
        Assert.assertNotEquals(r2,p.findUserByCode(2));
    }

    @Test
    public void calculateTotalCostTest(){
        PhoneCompany p = new PhoneCompany(0.10,0.05,1);
        User r = new User(1,"Salvatore","Ruocco");
        p.add(r);

        r.setUsedMinutes(200);
        r.setUsedSMS(200);
        r.setUsedMB(4000);
        p.calculateTotalCost(r);

        Assert.assertEquals(34,r.getTotalCost(),0);
    }
}
