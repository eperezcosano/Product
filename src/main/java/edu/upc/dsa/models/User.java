package edu.upc.dsa.models;

import java.util.ArrayList;
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

    }

    public User(String idUser, String name, String surname) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.orders = new LinkedList<>();
    }

    //Methods
    @Override
    public String toString() {
        String string =
                "[id: " + idUser + ", " +
                "Name: " + name + ", " +
                "Surname: " + surname + " , " +
                "Orders: ";
        for (Order order : orders) {
            string += order.getName() + ", ";
        }
        string += "]";
        return string;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getOrdersSold() {
        List<Order> res = new ArrayList<>();
        for (Order order : orders) {
            if (order.isSold()) res.add(order);
        }
        return res;
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
