package co.edu.poli.corte2.repositories.implementations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.poli.corte2.model.Customer;
import co.edu.poli.corte2.model.Product;
import co.edu.poli.corte2.repositories.interfaces.IProductRepository;

public class ProductRepository implements IProductRepository {
    
    private static List<Product> products = new ArrayList<>();
    private static UserRepository instance;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_PATH = "src/main/resources/products.json";

    public List<Product> getAllProducts() throws Exception{
        return products;
    }

    public Product getProduct(int id) throws Exception{
        try {
            List<Product> products = getAllProducts();
            return products.stream()
                   .filter(product -> product.getId() == id)
                   .findFirst()
                   .orElse(null); 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private void loadFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                products = objectMapper.readValue(file, new TypeReference<List<Product>>() {
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ProductRepository() {
        loadFromFile();
    }
}
