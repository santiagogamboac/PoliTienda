package co.edu.poli.corte2.model;

import java.util.List;

/**
 *
 */
public class Customer {

    /**
     * Default constructor
     */
    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    private int id;

    private String name;

    private String email;
    private List<PaymentMethod> paymentMethods;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter y Setter para email
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
