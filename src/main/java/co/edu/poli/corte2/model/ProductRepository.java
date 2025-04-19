package co.edu.poli.corte2.model;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    
    private static Map<Integer, Product> products = new HashMap<>();
    private static UserRepository instance;
    private Map<String, User> users;

    static {
        products.put(1, new Product(1, "Tablet Lenovo Tab Plus", "Tablet Lenovo Tab Plus - Luna Grey con Android", 999000));
        products.put(2, new Product(2, "SmartPhone Lenovo", "Celular ThinkPhone de Motorola", 1550000));
        products.put(3, new Product(3, "Laptop Lenovo IdeaPad", " Lenovo IdeaPad Slim 3i 8va Gen (15”, Intel)", 1899000));
        products.put(4, new Product(4, "Tablet Samsung", "Tablet Galaxy Tab S10 con Android", 5999000));
        products.put(5, new Product(5, "SmartPhone Samsung", "Galaxy S25 Ultra 5G", 5640000));
        products.put(6, new Product(6, "Televisor Samsung", "Televisor Smart 65” Crystal DU8200 65 Inch", 2450000));
        products.put(7, new Product(7, "Consola ASUS ROG Ally", "ROG Ally X (2024) RC72LA  RC72LA-NH007W", 4199000));
        products.put(8, new Product(8, "Laptop ASUS Vivobook", "Nombre completo del modelo - E1504FA-L1402W", 2199000));
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
                return products.get(id);
            }else {
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
