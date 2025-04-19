package co.edu.poli.corte2.model;

public class PaymentMethodStatus {

    private int id; // ID del método de pago
    private boolean active; // Estado del método de pago

    public PaymentMethodStatus() {
    }

    public PaymentMethodStatus(int id, boolean active) {
        this.id = id;
        this.active = active;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
