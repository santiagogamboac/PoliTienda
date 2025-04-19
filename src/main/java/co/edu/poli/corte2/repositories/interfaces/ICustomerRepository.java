package co.edu.poli.corte2.repositories.interfaces;

import java.util.List;

import co.edu.poli.corte2.model.Customer;

public interface ICustomerRepository {

    List<Customer> getAll();

    Customer getById(int id);

    void update(int id, Customer updatedCustomer);

    Customer create(Customer customer);

}
