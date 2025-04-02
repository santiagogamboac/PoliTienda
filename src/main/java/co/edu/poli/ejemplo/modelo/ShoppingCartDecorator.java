package co.edu.poli.ejemplo.modelo;

import java.util.List;

abstract class ShoppingCartDecorator implements ShoppingCart {
    protected ShoppingCart shoppingCart;

    public ShoppingCartDecorator(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public double calculateTotal() {
        return shoppingCart.calculateTotal();
    }

    @Override
    public List<ProductoAlimento> getItems() {
        return shoppingCart.getItems();
    }

    @Override
    public void addItem(ProductoAlimento item) {
        shoppingCart.addItem(item);
    }

    @Override
    public void removeItem(ProductoAlimento item) {
        shoppingCart.removeItem(item);
    }

    @Override
    public String getDescription() {
        return shoppingCart.getDescription();
    }
}

