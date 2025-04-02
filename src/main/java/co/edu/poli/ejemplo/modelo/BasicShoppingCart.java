package co.edu.poli.ejemplo.modelo;


import java.util.ArrayList;
import java.util.List;
// Concrete Component
public class BasicShoppingCart implements ShoppingCart {
    private List<ProductoAlimento> items = new ArrayList<>();

    @Override
    public double calculateTotal() {
        return  1.00 ;
        //items.stream().mapToDouble(ProductoAlimento::getPrice).sum();
    }

    @Override
    public List<ProductoAlimento> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public void addItem(ProductoAlimento item) {
        items.add(item);
    }

    @Override
    public void removeItem(ProductoAlimento item) {
        items.remove(item);
    }

    @Override
    public String getDescription() {
        return "Basic Shopping Cart";
    }
}