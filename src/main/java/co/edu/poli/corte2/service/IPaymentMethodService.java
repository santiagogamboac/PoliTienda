package co.edu.poli.corte2.service;

import java.util.List;

import co.edu.poli.corte2.model.PaymentMethod;

/**
 *
 */
public interface IPaymentMethodService {

    /**
     * @return
     */
    public List<PaymentMethod> getPaymentMethods();

    PaymentMethod findById(int id);

    public void toggleStatus(int customerId, int paymentMethodId);

}
