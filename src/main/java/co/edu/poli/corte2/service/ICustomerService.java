package co.edu.poli.corte2.service;

import java.util.List;

import co.edu.poli.corte2.model.Customer;

/**
 * 
 */
public interface ICustomerService {

    /**
     * @param id 
     * @return
     */
    public Customer getCustomer(int id);

    /**
     * @return
     */
    public List<Customer> getAllCustomer();

    /**
     * @param data 
     * @return
     */
    public Customer createCustomer(Customer data);

    /**
     * @param id 
     * @param data 
     * @return
     */
    public Customer updateCustomer(int id, Customer data);

    /**
     * 
     */
    

}