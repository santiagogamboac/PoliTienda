package co.edu.poli.corte2.repositories.interfaces;

import java.util.List;

import co.edu.poli.corte2.model.Order;

public interface IOrderRepository {

    List<Order> getOrdersByCustomerId(int id);
}
