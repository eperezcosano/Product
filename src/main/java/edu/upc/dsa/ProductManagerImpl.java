package edu.upc.dsa;

import edu.upc.dsa.exceptions.*;
import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;

import java.util.*;

public class ProductManagerImpl implements ProductManager {

    //Logger
    private final static Logger log = Logger.getLogger(ProductManagerImpl.class.getName());

    //Facade
    private static ProductManagerImpl instance;
    private List<Product> products;
    private LinkedList<Order> orders;
    private HashMap<String, User> users;

    //Private Constructor
    private ProductManagerImpl() {
        this.products = new LinkedList<>();
        this.orders = new LinkedList<>();
        this.users = new HashMap<>();
    }

    //getInstance Method
    public static ProductManager getInstance() {
        if (instance == null) instance = new ProductManagerImpl();
        return instance;
    }

    @Override
    public void addUser(String name, String surname) {
        User user = new User(name, surname);
        this.users.put(user.getIdUser(), user);
        log.info("User added");
    }

    @Override
    public void addProduct(String name, double price) {
        Product product = new Product(name, price);
        this.products.add(product);
        log.info("Product added");
    }

    //Methods
    @Override
    public List<Product> getProductsByPrice() {
        //Start
        List<Product> products = this.products;
        log.info("List of products (without order): " + products);

        //Sort by price
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });

        //End
        log.info("List of products (ordered by price): " + products);
        return products;
    }

    @Override
    public void placeOrder(Order order, String idUser) throws UserNotFoundException {
        //Start
        log.info("List of orders:" + this.orders);

        //Search user
        User user = this.users.get(idUser);
        if (user == null) {
            log.error("User not found");
            throw new UserNotFoundException();
        }

        //Add order to list of orders
        this.orders.add(order);

        //Add order to user
        user.addOrder(order);
        log.info("Order added to user: " + user.getName());
        log.info("Actual orders of this user: " + user.getOrders());

        //End
        log.info("List of orders:" + this.orders);
    }

    @Override
    public void serveOrder() {
        //Start
        log.info("List of orders:" + this.orders);

        //Order to serve
        Order order = this.orders.remove();
        log.info("Order to serve: " + order);

        //Increment sales of every product in the order
        for (Product product : order.getProducts()) {
            product.addSale();
            log.info("Product: " + product.getName() + ", Sale incremented: " + product.getSales());
        }

        //Set order sold
        order.setSold(true);
        log.info("Order served");

        //End
        log.info("List of orders:" + this.orders);

    }

    @Override
    public List<Order> getPlacedOrders(String idUser) throws UserNotFoundException {
        //Start
        log.info("List of orders:" + this.orders);

        //Search user
        User user = this.users.get(idUser);
        if (user == null) {
            log.error("User not found");
            throw new UserNotFoundException();
        }
        log.info("User: " + user.getName());

        //End
        log.info("List of orders: " + user.getOrders());
        log.info("List of orders sold: " + user.getOrdersSold());
        return user.getOrdersSold();
    }

    @Override
    public List<Product> getProductsBySales() {
        //Start
        List<Product> products = this.products;
        log.info("List of products (without order): " + products);

        //Sort by sales
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o1.getSales() - o2.getSales());
            }
        });

        //End
        log.info("List of products (ordered by sales): " + products);
        return products;
    }

    @Override
    public int numProducts() {
        return this.products.size();
    }

    @Override
    public int numOrders() {
        return this.orders.size();
    }

    @Override
    public int numUsers() {
        return this.users.size();
    }

    @Override
    public void clear() {
        this.products = new LinkedList<>();
        this.orders = new LinkedList<>();
        this.users = new HashMap<>();
    }
}
