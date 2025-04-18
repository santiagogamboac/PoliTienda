package co.edu.poli.corte2.repositories.interfaces;

import java.util.Collection;
import java.util.List;

import co.edu.poli.corte2.model.PaymentMethod;

public interface IPaymentMethodRepository {

    Collection<PaymentMethod> getAll();

    PaymentMethod getById(int id);

    void update(PaymentMethod method);

    List<PaymentMethod> getByCustomerId(int customerId);

}
