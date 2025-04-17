package co.edu.poli.corte2.repositories.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.poli.corte2.model.Customer;
import co.edu.poli.corte2.repositories.interfaces.ICustomerRepository;

public class CustomerRepository implements ICustomerRepository {
    private Map<Integer, Customer> database = new HashMap<>();

    @Override
    public Customer getById(int id) {
        return database.get(id);
    }
@Override
public List<Customer> getAll() {
    return new ArrayList<>(database.values());
}
    @Override
    public Customer update(int id, Customer updatedCustomer) {
        database.put(id, updatedCustomer); // simula actualización
        return updatedCustomer;
    }
    @Override
    public Customer create(Customer data) {
       
        return data;
    }
    // Método para simular clientes existentes
    public void seedData() {
        database.put(1, new Customer(1, "Alice", "alice@email.com"));
        database.put(2, new Customer(2, "Bob", "bob@email.com"));
    }
}
