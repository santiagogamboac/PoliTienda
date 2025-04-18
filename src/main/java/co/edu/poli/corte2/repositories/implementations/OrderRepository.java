package co.edu.poli.corte2.repositories.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.poli.corte2.model.Order;
import co.edu.poli.corte2.repositories.interfaces.IOrderRepository;

public class OrderRepository implements IOrderRepository {

    private Map<Integer, List<Order>> ordersDatabase;

    public OrderRepository() {
        // Simular la base de datos con un HashMap
        ordersDatabase = new HashMap<>();

        // Crear algunos pedidos para simular la base de datos
        List<Integer> order1ProductIds = new ArrayList<>();
        order1ProductIds.add(1);  // Producto 1
        order1ProductIds.add(2);  // Producto 2
        ordersDatabase.put(1, new ArrayList<>());
        ordersDatabase.get(1).add(new Order(123, 1, java.time.LocalDate.of(2023, 12, 15), order1ProductIds));

        List<Integer> order2ProductIds = new ArrayList<>();
        order2ProductIds.add(2);  // Producto 2
        order2ProductIds.add(3);  // Producto 3
        ordersDatabase.put(1, new ArrayList<>());
        ordersDatabase.get(1).add(new Order(124, 1, java.time.LocalDate.of(2023, 12, 16), order2ProductIds));

        List<Integer> order3ProductIds = new ArrayList<>();
        order3ProductIds.add(3);  // Producto 3
        ordersDatabase.put(2, new ArrayList<>());
        ordersDatabase.get(2).add(new Order(125, 2, java.time.LocalDate.of(2023, 12, 17), order3ProductIds));
    }

    // Método para obtener todos los pedidos de un cliente por su ID
    public List<Order> getOrdersByCustomerId(int customerId) {
        return ordersDatabase.getOrDefault(customerId, new ArrayList<>());
    }
}
