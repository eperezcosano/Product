package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.LinkedList;
import java.util.List;

public class User {

    //Attributes
    private String idUser;
    private String name;
    private String surname;
    private List<Order> orders;

    //Constructors
    public User() {
        this.idUser = RandomUtils.getId();
        this.orders = new LinkedList<>();
    }

    public User(String name, String surname) {
        this();
        this.name = name;
        this.surname = surname;
    }

    //Methods
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    //Getters and setters
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
