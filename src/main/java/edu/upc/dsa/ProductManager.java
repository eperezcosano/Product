package edu.upc.dsa;

import edu.upc.dsa.models.*;
import edu.upc.dsa.exceptions.*;

import java.util.List;

public interface ProductManager {

    /**
     * Add a new User
     * @param idUser user identifier
     * @param name name of the user
     * @param surname surname of the user
     */
    void addUser(String idUser, String name, String surname);

    /**
     * Add a new Product
     * @param name name of the product
     * @param price price of the product
     */
    void addProduct(String name, double price);

    /**
     * List of ordered products (ascending) by price
     * @return list of products
     */
    List<Product> getProductsByPrice();

    /**
     * Place an order (which can consist of different products and in
     * different quantities) by an identified user
     * @param name order name
     * @param idProducts list of products identifier
     * @param idUser user identifier
     * @throws UserNotFoundException if user does not exist
     */
    void placeOrder(String name, List<String> idProducts, String idUser) throws ProductNotFoundException, UserNotFoundException;

    /**
     * Serve an order. The services are carried out in order of arrivals
     */
    void serveOrder();

    /**
     * List of orders of a user that have already been made
     * @param idUser user identifier
     * @throws UserNotFoundException if user does not exist
     * @return list of orders
     */
    List<Order> getPlacedOrders(String idUser) throws UserNotFoundException;

    /**
     * List of ordered products (descending) by number of sales
     * @return list of products
     */
    List<Product> getProductsBySales();

    /**
     * Get number of products
     * @return number of products
     */
    int numProducts();

    /**
     * Get number of orders
     * @return number of orders
     */
    int numOrders();

    /**
     * Get number of users
     * @return number of users
     */
    int numUsers();

    /**
     * Clear data structures
     */
    void clear();
}
