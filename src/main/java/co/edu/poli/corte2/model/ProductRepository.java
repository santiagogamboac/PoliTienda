package co.edu.poli.corte2.model;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    
    private static Map<Integer, Product> products = new HashMap<>();
    private static UserRepository instance;
    private Map<String, User> users;

    static {
        products.put(1, new Product(1, "Tablet Lenovo", "Tableta con Android", 380000));
        products.put(2, new Product(2, "SmartPhone Samsung", "Celular gama alta", 4850000));
        products.put(3, new Product(3, "Laptop ASUS", "Laptop de gaming", 3299000));
    }

    public static Map<Integer, Product> getAllProducts() throws Exception{
        try {
            return products;
            
        } catch (Exception e) {
            return null;
        }
    }

    public static Product getProduct(int id) throws Exception{
        try {
            if(products.containsKey(id)){
                System.out.println("si hay Producto");
                return products.get(id);
            }else {
                System.out.println("no hay Producto");
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }
}
