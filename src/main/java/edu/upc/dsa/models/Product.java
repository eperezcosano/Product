package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Product {

    //Attributes
    private String idProduct;
    private String name;
    private double price;

    //Constructors
    public Product() {
        this.idProduct = RandomUtils.getId();
    }

    public Product(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }

    //Getters and setters
    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
