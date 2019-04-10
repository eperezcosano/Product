package edu.upc.dsa;

import edu.upc.dsa.models.*;
import edu.upc.dsa.exceptions.*;

import java.util.List;

public interface ProductManager {

    /**
     * List of ordered products (ascending) by price
     * @return list of products
     */
    List<Product> getProductsByPrice();

    /**
     * Place an order (which can consist of different products and in
     * different quantities) by an identified user
     * @param order an order
     * @param idUser user identifier
     * @throws UserNotFoundException if user does not exist
     */
    void placeOrder(Order order, String idUser) throws UserNotFoundException;

    /**
     * Serve an order. The services are carried out in order of arrivals
     */
    void serveOrder(Order order);

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
}
