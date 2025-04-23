package co.edu.poli.corte2.repositories.interfaces;

import java.util.List;

import co.edu.poli.corte2.model.Product;
import co.edu.poli.corte2.repositories.implementations.UserRepository;

public interface IProductRepository {

    public List<Product> getAllProducts() throws Exception;
    public Product getProduct(int id) throws Exception;
    public String addProduct(Product producto) throws Exception;
    public UserRepository getInstance();
}
