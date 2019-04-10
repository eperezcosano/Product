package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Order {

    //Attributes
    private String idOrder;
    private List<Product> products;

    //Constructors
    public Order() {
        this.products = new LinkedList<>();
    }

    public Order(String idOrder) {
        this.idOrder = idOrder;
        this.products = new LinkedList<>();
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

}
