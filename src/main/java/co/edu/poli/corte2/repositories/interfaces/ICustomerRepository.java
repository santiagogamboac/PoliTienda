package co.edu.poli.corte2.repositories.interfaces;

import java.util.List;

import co.edu.poli.corte2.model.Customer;

public interface ICustomerRepository {

    Customer getById(int id);

    List<Customer> getAll();

    Customer update(int id, Customer updatedCustomer);

    Customer create(Customer customer);

    void seedData();
}
