package co.edu.poli.corte2.service;

import co.edu.poli.corte2.model.Order;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface IOrderService {

    /**
     * @param id 
     * @return
     */
    public Order getOrder(int id);

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