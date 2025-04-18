package co.edu.poli.corte2.repositories.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.poli.corte2.model.Customer;
import co.edu.poli.corte2.model.PaymentMethod;
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

    @Override
    public void seedData() {

        List<PaymentMethod> alicePaymentMethods = List.of(
                new PaymentMethod(1, "Tarjeta de Crédito", true),
                new PaymentMethod(2, "PayPal", true)
        );

        List<PaymentMethod> bobPaymentMethods = List.of(
                new PaymentMethod(3, "Efectivo", true)
        );

        database.put(1, new Customer(1, "Alice", "alice@email.com"));
        database.get(1).setPaymentMethods(alicePaymentMethods);

        database.put(2, new Customer(2, "Bob", "bob@email.com"));
        database.get(2).setPaymentMethods(bobPaymentMethods);
    }
}
