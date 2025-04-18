package co.edu.poli.corte2.service;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.corte2.model.Order;
import co.edu.poli.corte2.repositories.interfaces.IOrderRepository;

/**
 *
 */
public class OrderService implements IOrderService {

    private IOrderRepository customerRepository;

    public OrderService(IOrderRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Order> getOrdersByCustomerId(int orderId) {
        return customerRepository.getOrdersByCustomerId(orderId);

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
