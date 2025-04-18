package co.edu.poli.corte2.service;

import java.util.List;

import co.edu.poli.corte2.model.Order;

public interface IOrderService {

    /**
     * @param id
     * @return
     */
    public List<Order> getOrdersByCustomerId(int id);

    /**
     * @return
     */
    public List<Order> getAllOrders();

    /**
     * @param id
     * @return
     */
    public String processOrder(int id);

}
