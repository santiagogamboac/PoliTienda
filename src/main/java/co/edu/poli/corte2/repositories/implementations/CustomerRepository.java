package co.edu.poli.corte2.repositories.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.poli.corte2.model.Customer;
import co.edu.poli.corte2.model.PaymentMethod;
import co.edu.poli.corte2.repositories.interfaces.ICustomerRepository;

public class CustomerRepository implements ICustomerRepository {

    private static final String FILE_PATH = "src/main/resources/customers.json";
    private List<Customer> customers = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public CustomerRepository() {
        loadFromFile();
    }

    @Override
    public Customer getById(int id) {
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public void update(int id, Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == customer.getId()) {
                customers.set(i, customer);
                saveToFile();
                return;
            }
        }
    }

    @Override
    public Customer create(Customer data) {

        return data;
    }

    private void saveToFile() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                customers = objectMapper.readValue(file, new TypeReference<List<Customer>>() {
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
