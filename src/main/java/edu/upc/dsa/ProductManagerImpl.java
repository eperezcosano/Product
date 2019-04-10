package edu.upc.dsa;

import edu.upc.dsa.exceptions.*;
import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductManagerImpl implements ProductManager {

    //Logger
    private final static Logger log = Logger.getLogger(ProductManagerImpl.class.getName());

    //Facade
    private static ProductManagerImpl instance;
    private HashMap<String, Product> products;
    private HashMap<String, User> users;

    //Private Constructor
    private ProductManagerImpl() {
        this.products = new HashMap<>();
    }

    //getInstance Method
    public static ProductManager getInstance() {
        if (instance == null) instance = new ProductManagerImpl();
        return instance;
    }

    //Methods
    @Override
    public List<Product> getProductsByPrice() {
        List<Product> products = new ArrayList<>(this.products.values());
        log.info("List of products" + products);
        return products;
    }

    @Override
    public String placeOrder(List<Product> products, String idUser) throws UserNotFoundException {
        User user = this.users.get(idUser);
        if (user == null) {
            log.error("User not found");
            throw new UserNotFoundException();
        }
        this.products.put()
        return null;
    }

    @Override
    public void serveOrder(Order order) {

    }

    @Override
    public List<Order> getPlacedOrders(String idUser) throws UserNotFoundException {
        return null;
    }

    @Override
    public List<Product> getProductsBySales() {
        return null;
    }
}
