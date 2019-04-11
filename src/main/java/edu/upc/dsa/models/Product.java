package edu.upc.dsa.models;

public class Product {

    //Attributes
    private String name;
    private double price;
    private int sales;

    //Constructors
    public Product() {
        this.sales = 0;
    }

    public Product(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }

    //Methods
    public void addSale() {
        this.sales++;
    }

    //Getters and setters
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

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
