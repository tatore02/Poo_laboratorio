package it.unisa.supermarket;

import java.util.GregorianCalendar;

public abstract class Product {

    final private String code;
    final private String description;
    final private String brand;
    private double price;
    private boolean onSale;
    private double originalPrice;
    private GregorianCalendar lastOnSaleDay;

    public Product(String code, String description, String brand, double price) {
        this.code = code;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.originalPrice = price;
        this.onSale = false;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        /* TODO */
    }

    public void putOnSale(double p, GregorianCalendar g) {
        if(!this.onSale){
            double sconto = (getPrice() * p) / 100;
            setPrice(getPrice() - sconto);
            this.onSale = true;

            this.lastOnSaleDay = g;
        }
    }

    public void checkOnSale() {
        GregorianCalendar actualDay = new GregorianCalendar();
        if(actualDay.after(lastOnSaleDay) && onSale){
            onSale = false;
            this.price = originalPrice;
        }
    }

    public abstract boolean buy(int p);

}
