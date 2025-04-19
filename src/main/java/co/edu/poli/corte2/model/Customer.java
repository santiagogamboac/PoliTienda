package co.edu.poli.corte2.model;

import java.util.List;

/**
 *
 */
public class Customer {

    private int id;
    private String name;
    private String email;
    private User user;
    private List<PaymentMethodStatus> paymentMethodStatuses;

    public Customer() {
    }

    public Customer(int id, String name, String email, User user, List<PaymentMethod> paymentMethods) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.user = user;
        this.paymentMethodStatuses = paymentMethodStatuses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PaymentMethodStatus> getPaymentMethodStatuses() {
        return paymentMethodStatuses;
    }

    public void setPaymentMethodStatuses(List<PaymentMethodStatus> paymentMethodStatuses) {
        this.paymentMethodStatuses = paymentMethodStatuses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
