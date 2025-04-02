package co.edu.poli.ejemplo.modelo;

// Concrete Decorator - Points
public class PointsDecorator extends ShoppingCartDecorator {
    private static final double POINTS_RATE = 0.1; // 1 point for every $10 spent

    public PointsDecorator(ShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public double calculateTotal() {
        return super.calculateTotal(); // Points don't affect the total
    }

    public int calculatePoints() {
        return (int) (super.calculateTotal() * POINTS_RATE);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Points Rewards";
    }
}
