package it.unisa.financialhistory;

import java.util.ArrayList;
import java.util.List;

public class FinancialHistory {
    final private Person person;
    private double balance;
    final private List<Movement> movements;

    public FinancialHistory(Person person, double balance) {
        if(balance < 0){
            throw new IllegalArgumentException("Bilancio negativo");
        }
        this.person = person;
        this.balance = balance;
        this.movements = new ArrayList<>();
    }

    public void receiveFrom(int amount, String source) {
        Movement m = new Movement(source,amount);
        this.movements.add(m);
        balance += amount;
    }

    public void spendFor(int amount, String reason) {
        if(amount > this.balance){
            throw new IllegalArgumentException("Bilancio in rosso");
        }
        Movement m = new Movement(reason,amount);
        this.movements.add(m);
        balance -= amount;
    }

    public double cashOnHand() {
        return this.balance;
    }

    public double totalReceivedFrom(String source) {
        double tot = 0;
        for(Movement a : this.movements){
            if(a.getDescription().equals(source) && a.getAmount() > 0)
                tot += a.getAmount();
        }
        return tot;
    }

    public double totalSpentFor(String reason) {
        double tot = 0;
        for(Movement a : this.movements){
            if(a.getDescription().equals(reason) && a.getAmount() < 0)
                tot += a.getAmount();
        }
        return tot;
    }

    public void printMovements() {
        for(Movement a : this.movements){
            if(a.getAmount() > 0)
                System.out.println("Ricevuti: " + a.getAmount() + " per " + a.getDescription());
            else
                System.out.println("Spesi: " + a.getAmount() + " per " + a.getDescription());
        }
    }

}
