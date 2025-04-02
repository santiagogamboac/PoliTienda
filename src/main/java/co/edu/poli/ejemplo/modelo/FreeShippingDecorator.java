package co.edu.poli.ejemplo.modelo;

public class FreeShippingDecorator extends ShoppingCartDecorator {
    private static final double SHIPPING_THRESHOLD = 100.0;
    private static final double SHIPPING_COST = 10.0;

    public FreeShippingDecorator(ShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public double calculateTotal() {
        double total = super.calculateTotal();
        return applyFreeShipping(total);
    }

    private double applyFreeShipping(double total) {
        if (total >= SHIPPING_THRESHOLD) {
            return total; // Free shipping
        } else {
            return total + SHIPPING_COST; // Add shipping cost
        }
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Free Shipping (over $" + SHIPPING_THRESHOLD + ")";
    }
}
