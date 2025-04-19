package co.edu.poli.corte2.service;

import java.util.List;

import co.edu.poli.corte2.model.Customer;
import co.edu.poli.corte2.repositories.interfaces.ICustomerRepository;

/**
 *
 */
public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepository.getById(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAll();
    }

    @Override
    public Customer createCustomer(Customer data) {
        return customerRepository.create(data);
    }

    @Override
    public void updateCustomer(int id, Customer data) {
        customerRepository.update(id, data);
    }
}
