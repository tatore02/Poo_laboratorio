import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(double initialBalance, String customerName) {
        /* TODO */
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount ba : this.accounts) {
            if (ba.getAccountNumber() == accountNumber)
                return ba;
        }
        return null;
    }

    public void deposit(int accountNumber, double amount) {
        /* TODO */
    }

    public void withdraw(int accountNumber, double amount) {
        /* TODO */
    }

    public double getBalance(int accountNumber) {
        /* TODO */
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        /* TODO */
    }
}