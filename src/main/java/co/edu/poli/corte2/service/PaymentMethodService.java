package co.edu.poli.corte2.service;

import java.util.List;

import co.edu.poli.corte2.model.PaymentMethod;
import co.edu.poli.corte2.repositories.interfaces.IPaymentMethodRepository;

/**
 *
 */
public class PaymentMethodService implements IPaymentMethodService {

    private IPaymentMethodRepository repository;

    public PaymentMethodService(IPaymentMethodRepository repository) {
        this.repository = repository;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return null;
    }

    public void toggleStatus(int id) {
        PaymentMethod method = repository.getById(id);
        method.setActive(!method.isActive());
        repository.update(method);
    }

    @Override
    public List<PaymentMethod> getPaymentMethodsByCustomerId(int customerId) {
        return repository.getByCustomerId(customerId);

    }
}
