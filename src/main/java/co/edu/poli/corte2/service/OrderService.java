package co.edu.poli.corte2.service;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.corte2.model.Order;

/**
 * 
 */
public class OrderService implements  IOrderService {

    /**
     * Default constructor
     */
    public OrderService() {
    }

    @Override
public Order getOrder(int orderId) {
    // Implementación básica del método
    System.out.println("Fetching order with ID: " + orderId);
    return null; // Devuelve un valor nulo o una instancia de Order según sea necesario
}

@Override
public List<Order> getAllOrders() {
    // Implementación básica del método
    System.out.println("Fetching all orders");
    return new ArrayList<>(); // Devuelve una lista vacía o una lista con órdenes según sea necesario
}
    @Override
    public String processOrder(int orderId) {
        // Implementación básica del método
        System.out.println("Processing order with ID: " + orderId);
        return "a"; 
    }
}