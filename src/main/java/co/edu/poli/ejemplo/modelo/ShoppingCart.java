package co.edu.poli.ejemplo.modelo;

import java.util.List;

public interface ShoppingCart {
    double calculateTotal();
    List<ProductoAlimento> getItems();
    void addItem(ProductoAlimento item);
    void removeItem(ProductoAlimento item);
    String getDescription();
}
