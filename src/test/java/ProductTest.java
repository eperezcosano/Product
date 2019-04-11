import edu.upc.dsa.ProductManager;
import edu.upc.dsa.ProductManagerImpl;
import edu.upc.dsa.exceptions.ProductNotFoundException;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.Order;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {

    private ProductManager productManager;

    @Before
    public void setUp() {

        this.productManager = ProductManagerImpl.getInstance();

        Assert.assertEquals(0, this.productManager.numUsers());

        this.productManager.addUser("User1","Ethan", "Perez");
        this.productManager.addUser("User2","Charlotte", "Mont");

        Assert.assertEquals(2, this.productManager.numUsers());
        Assert.assertEquals(0, this.productManager.numProducts());

        this.productManager.addProduct("Apple", 1.60);
        this.productManager.addProduct("Pizza", 7.95);
        this.productManager.addProduct("Hamburger", 4.15);

        Assert.assertEquals(3, this.productManager.numProducts());
        Assert.assertEquals(0, this.productManager.numOrders());

    }

    @After
    public void tearDown() {
        this.productManager.clear();

        Assert.assertEquals(0, this.productManager.numUsers());
        Assert.assertEquals(0, this.productManager.numOrders());
        Assert.assertEquals(0, this.productManager.numProducts());
    }

    @Test
    public void testPlaceOrder() throws ProductNotFoundException, UserNotFoundException {

        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Apple");
        list.add("Pizza");
        list.add("Pizza");
        list.add("Hamburger");
        list.add("Apple");

        Assert.assertEquals(0, this.productManager.numOrders());

        this.productManager.placeOrder("My Shopping List", list, "User1");

        Assert.assertEquals(1, this.productManager.numOrders());
    }

    @Test
    public void testServeOrder() {

    }
}
