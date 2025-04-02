package co.edu.poli.ejemplo.modelo;

// Concrete Decorator - Discount
public class DiscountDecorator extends ShoppingCartDecorator {
    private double discountPercentage;

    public DiscountDecorator(ShoppingCart shoppingCart, double discountPercentage) {
        super(shoppingCart);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculateTotal() {
        double total = super.calculateTotal();
        return applyDiscount(total);
    }

    private double applyDiscount(double amount) {
        return amount * (1 - discountPercentage / 100.0);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + " + discountPercentage + "% Discount";
    }
}