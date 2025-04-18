package co.edu.poli.corte2.model;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private int orderId;
    private int customerId;
    private LocalDate date;
    private float total;
    private List<Integer> productIds;

    public Order(int orderId, int customerId, LocalDate date, List<Integer> productIds) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
        this.productIds = productIds;
    }

    public int getOrderId() {
        return orderId;
    }

    public int CustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getTotal() {
        return total;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
