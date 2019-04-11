package edu.upc.dsa.services;

import edu.upc.dsa.*;
import edu.upc.dsa.exceptions.*;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/products", description = "Endpoint to ProductManagerServices")
@Path("/products")
public class ProductManagerServices {

    private ProductManager productManager;

    public ProductManagerServices() throws ProductNotFoundException, UserNotFoundException {

        this.productManager = ProductManagerImpl.getInstance();

        if (this.productManager.numUsers() == 0) {
            this.productManager.addUser("User1", "Ethan", "Perez");
            this.productManager.addUser("User2", "Charlotte", "Mont");

            this.productManager.addProduct("Apple", 1.60);
            this.productManager.addProduct("Pizza", 7.95);
            this.productManager.addProduct("Hamburger", 4.15);

            List<String> list1 = new ArrayList<>();
            list1.add("Apple");
            list1.add("Apple");
            list1.add("Pizza");

            List<String> list2 = new ArrayList<>();
            list2.add("Pizza");
            list2.add("Hamburger");
            list2.add("Apple");

            this.productManager.placeOrder("My Shopping List 0", list1, "User1");
            this.productManager.placeOrder("My Shopping List 1", list2, "User2");
            this.productManager.placeOrder("My Shopping List 2", list2, "User1");
        }

    }

    @GET
    @ApiOperation(value = "get list of products ordered by price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/price")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsOrderedByPrice() {
        List<Product> products = this.productManager.getProductsByPrice();
        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(products) {};
        return Response.status(200).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get list of products ordered by sales")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/sales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsOrderedBySales() {
        List<Product> products = this.productManager.getProductsBySales();
        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(products) {};
        return Response.status(200).entity(entity).build();
    }

    @POST
    @ApiOperation(value = "place an order")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "ProductNotFoundException"),
            @ApiResponse(code = 405, message = "UserNotFoundException")
    })
    @Path("/order/{name}/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response placeOrder(@PathParam("name") String name, @PathParam("idUser") String idUser, List<String> idProducts) {
        try {
            this.productManager.placeOrder(name, idProducts, idUser);
            return Response.status(201).build();
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return Response.status(405).build();
        }
    }

    @POST
    @ApiOperation(value = "serve order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful")
    })
    @Path("/order")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response placeOrder() {
        this.productManager.serveOrder();
        return Response.status(200).build();
    }

    @GET
    @ApiOperation(value = "get list of orders of a user that have already been made")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Order.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "UserNotFoundException")
    })
    @Path("/orders/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlacedOrdersByUser(@PathParam("idUser") String idUser) {
        try {
            List<Order> orders = this.productManager.getPlacedOrders(idUser);
            GenericEntity<List<Order>> entity = new GenericEntity<List<Order>>(orders) {};
            return Response.status(200).entity(entity).build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }
}
