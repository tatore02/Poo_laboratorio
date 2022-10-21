import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

    @Before
    public void setup() {
        BankAccount.totalNumberOfAccounts = 0;
    }

    @Test
    public void findAccountTest() {
        Bank b = new Bank();
        b.addAccount(1000, "Dario");
        BankAccount newAccount = b.find(1);
        Assert.assertEquals(1, newAccount.getAccountNumber());
        Assert.assertEquals(1000, newAccount.getBalance(), 0);
        Assert.assertEquals("Dario", newAccount.getCustomerName());
    }

    @Test
    public void depositTest() {
        /* TODO */
    }

    @Test
    public void withdrawTest() {
        /* TODO */
    }

    @Test
    public void transferTest() {
        /* TODO */
    }
}