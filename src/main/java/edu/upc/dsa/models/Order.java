package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.LinkedList;
import java.util.List;

public class Order {

    //Attributes
    private String idOrder;
    private List<Product> products;
    private boolean sold;

    //Constructors
    public Order() {
        this.idOrder = RandomUtils.getId();
        this.products = new LinkedList<>();
        this.sold = false;
    }

    public Order(List<Product> products) {
        this();
        this.products = products;
    }

    //Getters and setters
    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
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
