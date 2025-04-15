package co.edu.poli.corte2.model;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    
    private static Map<String, Product> products = new HashMap<>();

    static {
        products.put("admin", new Product(1, "Tablet Lenovo", "Tableta con Android", 380000));
        products.put("juan", new Product(2, "SmartPhone Samsung", "Celular gama alta", 4850000);
    }

    public static User getUser(String username, String password) throws Exception{
        try {
            Product producto = products.get(username);
            if(producto.getUserName().equals(username) && producto.getPassword().equals(password)){
                return products.get(username);
            }else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
