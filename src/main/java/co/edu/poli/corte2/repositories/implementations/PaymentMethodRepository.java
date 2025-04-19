package co.edu.poli.corte2.repositories.implementations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.poli.corte2.model.Customer;
import co.edu.poli.corte2.model.PaymentMethod;
import co.edu.poli.corte2.model.PaymentMethodStatus;
import co.edu.poli.corte2.repositories.interfaces.IPaymentMethodRepository;

public class PaymentMethodRepository implements IPaymentMethodRepository {

    private Map<Integer, PaymentMethod> paymentMethods = new HashMap<>();
    private Map<Integer, Customer> customers = new HashMap<>(); // ✅ Agregado

    private static final String PAYMENT_FILE_PATH = "src/main/resources/payment_methods.json";
    private static final String CUSTOMER_FILE_PATH = "src/main/resources/customers.json";

    private ObjectMapper objectMapper = new ObjectMapper();

    public PaymentMethodRepository() {
        loadData();
    }

    private void loadData() {
        try {
            // Cargar clientes
            File customerFile = new File(CUSTOMER_FILE_PATH);
            if (customerFile.exists()) {
                Customer[] loadedCustomers = objectMapper.readValue(customerFile, Customer[].class);
                for (Customer customer : loadedCustomers) {
                    customers.put(customer.getId(), customer);
                }
            }

            // Cargar métodos de pago generales
            File paymentFile = new File(PAYMENT_FILE_PATH);
            if (paymentFile.exists()) {
                PaymentMethod[] loadedMethods = objectMapper.readValue(paymentFile, PaymentMethod[].class);
                for (PaymentMethod pm : loadedMethods) {
                    paymentMethods.put(pm.getId(), pm);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PaymentMethod> getAll() {
        // Retorna todos los métodos de pago disponibles
        return paymentMethods.values().stream().collect(Collectors.toList());
    }

    public List<PaymentMethod> findAll() {
        return paymentMethods.values().stream().collect(Collectors.toList());
    }

    public PaymentMethod findById(int id) {
        return paymentMethods.get(id);
    }

    private void saveData() {
        try {
            File file = new File(PAYMENT_FILE_PATH);
            objectMapper.writeValue(file, paymentMethods.values().toArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveCustomerData() {
        try {
            File file = new File(CUSTOMER_FILE_PATH);
            objectMapper.writeValue(file, customers.values().toArray(new Customer[0])); // ✅ Arreglo aquí
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PaymentMethod> updatePaymentMethodStatus(int customerId, int paymentMethodId) {
        Customer customer = customers.get(customerId);
        List<PaymentMethod> paymentMethodDTOs = new ArrayList<>();
        if (customer != null) {
            List<PaymentMethodStatus> statuses = customer.getPaymentMethodStatuses();

            PaymentMethodStatus targetStatus = statuses.stream()
                    .filter(status -> status.getId() == paymentMethodId)
                    .findFirst()
                    .orElse(null);

            if (targetStatus != null) {
                targetStatus.setActive(!targetStatus.isActive());
                saveCustomerData();
                return getPaymentMethodsForTable(customerId);
                //System.out.println("Estado actualizado para método ID " + paymentMethodId + " del cliente ID " + customerId);
            } else {
                System.out.println("Método de pago no encontrado en el cliente.");
            }
        }
        return paymentMethodDTOs;
    }

    public List<PaymentMethod> getPaymentMethodsForTable(int customerId) {
        Customer customer = customers.get(customerId);
        List<PaymentMethod> paymentMethodDTOs = new ArrayList<>();

        if (customer != null && customer.getPaymentMethodStatuses() != null) {
            for (PaymentMethodStatus status : customer.getPaymentMethodStatuses()) {
                PaymentMethod fullMethod = paymentMethods.get(status.getId());
                if (fullMethod != null) {
                    paymentMethodDTOs.add(new PaymentMethod(
                            fullMethod.getId(),
                            fullMethod.getName(), // Nombre del método de pago
                            status.isActive()
                    ));
                }
            }
        }

        return paymentMethodDTOs;
    }
}
