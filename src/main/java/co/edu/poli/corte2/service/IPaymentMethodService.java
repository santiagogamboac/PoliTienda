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

    public void toggleStatus(int id);

    public List<PaymentMethod> getPaymentMethodsByCustomerId(int id);

}
