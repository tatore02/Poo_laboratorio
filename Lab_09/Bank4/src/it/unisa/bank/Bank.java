package it.unisa.bank;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;

public class Bank {

    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount bankAccount) {
        this.accounts.add(bankAccount);
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount ba : this.accounts) {
            if (ba.getAccountNumber() == accountNumber)
                return ba;
        }
        return null;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = this.find(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) {
        BankAccount account = this.find(accountNumber);
        account.withdraw(amount);
    }

    public double getBalance(int accountNumber) {
        BankAccount account = this.find(accountNumber);
        return account.getBalance();
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = this.find(fromAccountNumber);
        BankAccount toAccount = this.find(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner in  = new Scanner(file);
        int i = 0;
        try {
            while(in.hasNextLine()) {
                String accountLine = in.nextLine();
                String[] accountValues = accountLine.split(",");

                int accountNumber = Integer.parseInt(accountValues[0]);
                String customerName = accountValues[1];
                double balance = Double.parseDouble(accountValues[2]);

                if(accountValues.length == 4){
                    double interestRate = Double.parseDouble(accountValues[3]);
                    SavingAccount savingAccount = new SavingAccount(accountNumber,customerName,balance,interestRate);
                    this.addAccount(savingAccount);
                }
                else{
                    BankAccount bankAccount = new BankAccount(accountNumber,customerName,balance);
                    this.addAccount(bankAccount);
                }
            }
        }
        catch (NoSuchElementException | NumberFormatException ex){
            System.err.println("Formato file errato");
            ex.printStackTrace();
        }

    }

    public void writeUserDataToFile(File file, boolean overwrite) throws FileNotFoundException, FileAlreadyExistsException {
        if(overwrite == false){
            if(file.exists()){
                throw new FileAlreadyExistsException("Il file già esiste");
            }
            else
                writeUserDataToFile(file);
        }
        else{
            String nameFile = file.getName();
            File parentFile = file.getParentFile();
            file.delete();
            File newFile = new File(parentFile,nameFile);
            writeUserDataToFile(newFile);
        }
    }

    public void writeUserDataToFile(File file) throws FileNotFoundException{
        PrintWriter printWriter = new PrintWriter(file);
        for(BankAccount a : this.accounts){
            printWriter.print(a.getAccountNumber() + ", ");
            printWriter.print(a.getCustomerName() + ", ");
            printWriter.print(a.getBalance());
            if(a instanceof SavingAccount){
                printWriter.print(", " + ((SavingAccount) a).getInterestRate());
            }
            printWriter.println();
        }
        printWriter.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        this.accounts = (List<BankAccount>) objectInputStream.readObject();
        objectInputStream.close();
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(this.accounts);
        objectOutputStream.close();
    }
}