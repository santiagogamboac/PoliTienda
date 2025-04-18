package co.edu.poli.corte2.service;

import java.util.List;

import co.edu.poli.corte2.model.Customer;
import co.edu.poli.corte2.model.Order;
import co.edu.poli.corte2.model.PaymentMethod;

public class ShopAdminFacade {

    private ICustomerService customerService;
    private IOrderService orderService;
    private IPaymentMethodService paymentMethodService;

    public ShopAdminFacade(ICustomerService customerService,
            IOrderService orderService,
            IPaymentMethodService paymentMethodService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.paymentMethodService = paymentMethodService;
    }

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomer();
    }

    public Customer updateCustomer(int id, Customer updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer);
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    public void togglePaymentMethodStatus(int id) {
        paymentMethodService.toggleStatus(id);
    }

    public List<PaymentMethod> getPaymentMethodsByCustomerId(int id) {
        return paymentMethodService.getPaymentMethodsByCustomerId(id);
    }

}
