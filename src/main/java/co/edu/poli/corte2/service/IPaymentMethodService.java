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
    public List<PaymentMethod> getPaymenthMethods();

    /**
     * @param id 
     * @return
     */
    public String activatePaymentMethod(int id);

    /**
     * @param id 
     * @return
     */
    public String blockPaymentMethod(int id);

}