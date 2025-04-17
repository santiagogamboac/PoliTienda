package co.edu.poli.corte2.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.poli.corte2.model.Customer;
import co.edu.poli.corte2.repositories.implementations.CustomerRepository;
import co.edu.poli.corte2.repositories.interfaces.ICustomerRepository;
import co.edu.poli.corte2.service.CustomerService;
import co.edu.poli.corte2.service.ICustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerController implements Initializable {

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> nameColumn;
    @FXML
    private TableColumn<Customer, String> emailColumn;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private TextField txtIdProduct;

    @FXML
    void productDetails(ActionEvent event) {

    }
    private ICustomerService customerService;
    private ObservableList<Customer> customerData;

    public CustomerController() {
        // Constructor vacío requerido por FXMLLoader
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ICustomerRepository customerRepository = new CustomerRepository();
        if (customerRepository instanceof CustomerRepository) {
            ((CustomerRepository) customerRepository).seedData();
        }
        this.customerService = new CustomerService(customerRepository);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        loadCustomerData();
    }

    private void loadCustomerData() {
        // Obtener datos de clientes y cargarlos en la tabla
        customerData = FXCollections.observableArrayList(customerService.getAllCustomer());
        tblCustomer.setItems(customerData);
    }

}
