package co.edu.poli.corte2.service;

import java.util.ArrayList;
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

    public void updateCustomer(int id, Customer updatedCustomer) {
        customerService.updateCustomer(id, updatedCustomer);
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    public void togglePaymentMethodStatus(int customerId, int paymentMethodId) {
        paymentMethodService.toggleStatus(customerId, paymentMethodId);
    }

    public List<PaymentMethod> getPaymentMethodsByCustomerId(int id) {

        Customer customer = customerService.getCustomer(id);
        List<PaymentMethod> fullMethods = new ArrayList<>();
        if (customer != null && customer.getPaymentMethods() != null) {

            for (PaymentMethod pm : customer.getPaymentMethods()) {
                // Busca el PaymentMethod completo por ID
                PaymentMethod fullMethod = paymentMethodService.findById(pm.getId());
                if (fullMethod != null) {
                    // Agregar el nombre del PaymentMethod completo al que ya tiene el cliente
                    pm.setType(fullMethod.getType()); // Suponiendo que el PaymentMethod tiene un setName()
                    fullMethods.add(pm);
                }
            }
        }

        return fullMethods;
    }

}
