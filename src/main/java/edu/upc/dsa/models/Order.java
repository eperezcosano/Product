package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Order {

    //Attributes
    private String name;
    private List<Product> products;
    private boolean sold;

    //Constructors
    public Order() {
        this.products = new LinkedList<>();
        this.sold = false;
    }

    public Order(String name) {
        this();
        this.name = name;
    }

    //Methods
    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {

        String res = "";
        for (Product p : this.products) {
            res += p.getName() + ",";
        }

        return "[Name: " + this.name + ", " +
                "Products: " + res +
                " Sold: " + this.sold + "]";
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

}
