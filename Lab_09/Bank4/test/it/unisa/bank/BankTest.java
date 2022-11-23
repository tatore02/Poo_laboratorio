package it.unisa.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class BankTest {

    @Before
    public void setup() {
        BankAccount.totalNumberOfAccounts = 0;
    }

    @Test
    public void findAccountTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", 1000));
        BankAccount newAccount = b.find(1);
        Assert.assertEquals(1, newAccount.getAccountNumber());
        Assert.assertEquals(1000, newAccount.getBalance(), 0);
        Assert.assertEquals("Harry", newAccount.getCustomerName());
    }

    @Test
    public void depositTest() {
        Bank b = new Bank();
        b.addAccount(new SavingAccount("Harry", 1000, 1));
        BankAccount newAccount = b.find(1);
        Assert.assertEquals(1, newAccount.getAccountNumber());
        b.deposit(1, 1000);
        Assert.assertEquals(2000, b.getBalance(1), 0);
    }

    @Test
    public void withdrawTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", 1000));
        BankAccount newAccount = b.find(1);
        Assert.assertEquals(1, newAccount.getAccountNumber());
        b.withdraw(1, 200);
        Assert.assertEquals(800, b.getBalance(1), 0);
    }

    @Test
    public void transferTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", 1000));
        b.addAccount(new SavingAccount("Jules", 1000, 1));
        b.transfer(1, 2, 200);
        Assert.assertEquals(800, b.getBalance(1), 0);
        Assert.assertEquals(1200, b.getBalance(2), 0);
    }

    @Test
    public void interestComputationTest() {
        Bank b = new Bank();
        b.addAccount(new SavingAccount("Harry", 1000, 1));
        SavingAccount newAccount = (SavingAccount) b.find(1);
        newAccount.addInterest();
        Assert.assertEquals(1002.5, newAccount.getBalance(), 0);
    }

    @Test
    public void setAndGetInterestsTest() {
        Bank b = new Bank();
        b.addAccount(new SavingAccount("Harry", 1000, 1));
        SavingAccount newAccount = (SavingAccount) b.find(1);
        newAccount.setInterestRate(2);
        Assert.assertEquals(2, newAccount.getInterestRate(), 0);
        newAccount.addInterest();
        Assert.assertEquals(1005, newAccount.getBalance(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bankAccountWithNegativeBalanceTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", -1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalDepositTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", 1000));
        BankAccount newAccount = b.find(1);
        b.deposit(newAccount.getAccountNumber(), -100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalWithdrawTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", 1000));
        BankAccount newAccount = b.find(1);
        b.withdraw(newAccount.getAccountNumber(), 1100);
    }


    @Test
    public void writeUserDataToFileTest() throws FileAlreadyExistsException, FileNotFoundException {
        File file = new File("test/TestData.txt");
        Bank b1 = new Bank();
        BankAccount a1 = new BankAccount(1,"Sasa1",100);
        BankAccount a2 = new BankAccount(2,"Sasa2",200);
        BankAccount a3 = new BankAccount(3,"Sasa3",300);

        b1.addAccount(a1);
        b1.addAccount(a2);
        b1.addAccount(a3);

        b1.writeUserDataToFile(file,true);

        Bank b2 = new Bank();
        b2.readUserDataFromFile(file);
        Assert.assertEquals(3,b2.getAccounts().size());
        Assert.assertEquals(200,b2.getAccounts().get(1).getBalance(),0);

    }

    @Test
    public void writeSerializedDataToFileTest() {
        File file = new File("test/bin.dat");

        Bank b1 = new Bank();
        b1.addAccount(new BankAccount(1,"Sasa1",100));
        b1.addAccount(new BankAccount(2,"Sasa2",200));
        b1.addAccount(new BankAccount(3,"Sasa3",300));

        Bank b2 = new Bank();

        try {
            b1.writeSerializedDataToFile(file);
            b2.readSerializedDataFromFile(file);

            Assert.assertEquals(3,b2.getAccounts().size());
            Assert.assertEquals(200,b2.getAccounts().get(1).getBalance(),0);
        }
        catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}