import java.util.ArrayList;
import java.util.List;

public class Purse {

    final static Coin DOLLAR = new Coin("dollar", 1.00);
    final static Coin QUARTER = new Coin("quarter", 0.25);
    final static Coin DIME = new Coin("dime", 0.10);
    final static Coin NICKEL = new Coin("nickel", 0.05);
    final static Coin CENT = new Coin("cent", 0.01);

    private final List<Coin> coins;

    public Purse() {
        coins = new ArrayList<>();
    }

    public void add(Coin coin) {
        coins.add(coin);
    }

    public boolean find(Coin coin) {
        for(Coin search : this.coins)
            if(coin.equals(search))
                return true;

        return false;
    }

    public int count(Coin coin) {
        int tot = 0;
        for(Coin search : this.coins)
            if(coin.equals(search))
                tot++;
        return tot;
    }

    public Coin getMinimum() {
        Coin min = coins.get(0);
        for(Coin search : this.coins)
            if(search.getValue() < min.getValue())
                min = search;

        return min;
    }

    public Coin getMaximum() {
        Coin max = coins.get(0);
        for(Coin search : this.coins)
            if(search.getValue() > max.getValue())
                max = search;

        return max;
    }

    public double getTotal() {
        double tot = 0;
        for(Coin search : this.coins)
            tot += search.getValue();

        return tot;
    }

    public void remove(Coin coin) {
        this.coins.remove(coin);
    }

    public boolean hasCoin(Coin coin) {
        return this.coins.contains(coin);
    }

    @Override
    public String toString() {
        return "Purse[" +
                "Dollar = " + count(DOLLAR) + ", " +
                "Quarter = " + count(QUARTER) + ", " +
                "Dime = " + count(DIME) + ", " +
                "Nickel = " + count(NICKEL) + ", " +
                "Cent = " + count(CENT) +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purse purse = (Purse) o;
        return purse.count(DOLLAR) == this.count(DOLLAR)
                && purse.count(QUARTER) == this.count(QUARTER)
                && purse.count(DIME) == this.count(DIME)
                && purse.count(NICKEL) == this.count(NICKEL)
                && purse.count(CENT) == this.count(CENT);
    }
}