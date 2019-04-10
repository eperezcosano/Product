package edu.upc.dsa;

import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.Product;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class ProductManagerImpl implements ProductManager {

    //Logger
    private final static Logger log = Logger.getLogger(ProductManagerImpl.class.getName());

    //Facade
    private static ProductManagerImpl instance;
    private HashMap<String, Product> products;

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
        return null;
    }

    @Override
    public String placeOrder(List<Product> products, String idUser) throws UserNotFoundException {
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
