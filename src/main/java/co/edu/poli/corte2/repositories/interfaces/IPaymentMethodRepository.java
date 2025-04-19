package co.edu.poli.corte2.repositories.interfaces;

import java.util.List;

import co.edu.poli.corte2.model.PaymentMethod;

public interface IPaymentMethodRepository {

    List<PaymentMethod> getAll();  // Obtiene todos los métodos de pago

    public PaymentMethod findById(int id);

    List<PaymentMethod> updatePaymentMethodStatus(int customerId, int paymentMethodId);

}
