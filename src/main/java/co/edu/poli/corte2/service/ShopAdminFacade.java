package co.edu.poli.corte2.service;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.corte2.model.Customer;
import co.edu.poli.corte2.model.Order;
import co.edu.poli.corte2.model.PaymentMethod;
import co.edu.poli.corte2.model.PaymentMethodStatus;

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

    public void updateCustomer(int id, Customer updatedCustomer) {
        customerService.updateCustomer(id, updatedCustomer);
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    public List<PaymentMethod> togglePaymentMethodStatus(int customerId, int paymentMethodId) {
        return customerService.togglePaymentMethodStatus(customerId, paymentMethodId);
    }

    public List<PaymentMethod> getPaymentMethodsForTable(int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        List<PaymentMethod> paymentMethods = new ArrayList<>();

        if (customer != null && customer.getPaymentMethodStatuses() != null) {
            for (PaymentMethodStatus status : customer.getPaymentMethodStatuses()) {
                PaymentMethod paymentMethod = paymentMethodService.findById(status.getId());
                if (paymentMethod != null) {
                    paymentMethod.setActive(status.isActive()); // Combina el estado con el método de pago
                    paymentMethods.add(paymentMethod);
                }
            }
        }

        return paymentMethods;
    }

}
