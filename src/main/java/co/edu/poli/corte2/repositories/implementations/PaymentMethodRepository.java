package co.edu.poli.corte2.repositories.implementations;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import co.edu.poli.corte2.model.PaymentMethod;
import co.edu.poli.corte2.repositories.interfaces.IPaymentMethodRepository;

public class PaymentMethodRepository implements IPaymentMethodRepository {

    private Map<Integer, PaymentMethod> paymentMethods = new HashMap<>();

    public PaymentMethodRepository() {
        // Cargar algunos métodos de pago por defecto
        seedData();
    }

    private void seedData() {
        paymentMethods.put(1, new PaymentMethod(1, "Tarjeta", true));
        paymentMethods.put(2, new PaymentMethod(2, "Efectivo", true));
    }

    @Override
    public Collection<PaymentMethod> getAll() {
        return paymentMethods.values();
    }

    @Override
    public PaymentMethod getById(int id) {
        return paymentMethods.get(id);
    }

    @Override
    public void update(PaymentMethod method) {
        paymentMethods.put(method.getId(), method);
    }

    @Override
    public List<PaymentMethod> getByCustomerId(int customerId) {

        return paymentMethods.values().stream()
                .filter(method -> method.getId() == customerId)
                .collect(Collectors.toList());
    }
}
