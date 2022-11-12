package it.unisa.supermarket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Supermarket {

    private final List<Product> products;

    public Supermarket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
        this.products.sort(new ProductComparatorByCode());
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getProductType(int i) {
       Product p = products.get(i);
       if(p instanceof Grocery)
           return "Grocery";
       else if(p instanceof Electronic)
           return "Electronic";
       else
           return null;
    }

    public Product getMinPrice() {
        return Collections.min(products,new ProductComparatorByPrice());
    }

    public Product getMaxPrice() {
        return Collections.max(products,new ProductComparatorByPrice());
    }

    public List<Product> find(String brand) {
        List<Product> l = new ArrayList<>();
        for(Product search : products){
            if(search.getBrand().equals(brand))
                l.add(search);
        }
        return l;
    }
}
