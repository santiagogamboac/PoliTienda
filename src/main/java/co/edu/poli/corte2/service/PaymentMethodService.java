package co.edu.poli.corte2.service;

import java.util.List;

import co.edu.poli.corte2.model.PaymentMethod;
import co.edu.poli.corte2.repositories.interfaces.IPaymentMethodRepository;

/**
 *
 */
public class PaymentMethodService implements IPaymentMethodService {

    private final ICustomerService customerService;
    private final IPaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(ICustomerService customerService, IPaymentMethodRepository paymentMethodRepository) {
        this.customerService = customerService;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public List<PaymentMethod> getPaymentMethods() {
        return null;
    }

    @Override
    public PaymentMethod findById(int id) {
        return paymentMethodRepository.findById(id); // Utiliza el repositorio para encontrar el método por id
    }

    @Override
    public void toggleStatus(int customerId, int paymentMethodId) {
        paymentMethodRepository.updatePaymentMethodStatus(customerId, paymentMethodId);
    }

}
