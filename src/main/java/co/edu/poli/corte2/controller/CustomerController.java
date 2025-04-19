package co.edu.poli.corte2.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.poli.corte2.model.Customer;
import co.edu.poli.corte2.model.Order;
import co.edu.poli.corte2.model.PaymentMethod;
import co.edu.poli.corte2.model.Product;
import co.edu.poli.corte2.repositories.implementations.CustomerRepository;
import co.edu.poli.corte2.repositories.implementations.OrderRepository;
import co.edu.poli.corte2.repositories.implementations.PaymentMethodRepository;
import co.edu.poli.corte2.repositories.implementations.ProductRepository;
import co.edu.poli.corte2.repositories.interfaces.ICustomerRepository;
import co.edu.poli.corte2.repositories.interfaces.IOrderRepository;
import co.edu.poli.corte2.repositories.interfaces.IPaymentMethodRepository;
import co.edu.poli.corte2.service.CustomerService;
import co.edu.poli.corte2.service.ICustomerService;
import co.edu.poli.corte2.service.IOrderService;
import co.edu.poli.corte2.service.IPaymentMethodService;
import co.edu.poli.corte2.service.OrderService;
import co.edu.poli.corte2.service.PaymentMethodService;
import co.edu.poli.corte2.service.ShopAdminFacade;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class CustomerController implements Initializable {

    @FXML
    private TextField TxtEmail;

    @FXML
    private TextField TxtNombre;

    @FXML
    private Button BtnActualizar;
    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> nameColumn;
    @FXML
    private TableColumn<Customer, String> emailColumn;

    @FXML
    private TableView<Customer> tblCustomer;
    @FXML
    private TreeView<String> treeViewOrder;
    @FXML
    private TableView<PaymentMethod> tablePaymentMethods;

    @FXML
    private TableColumn<PaymentMethod, Void> colAccion;

    @FXML
    private TableColumn<PaymentMethod, String> colMetodo;

    @FXML
    private TableColumn<PaymentMethod, String> colStatus;

    @FXML
    private TextField txtIdProduct;

    @FXML
    void productDetails(ActionEvent event) {

    }
    private ICustomerService customerService;
    private ObservableList<Customer> customerData;
    private ProductRepository pr = new ProductRepository();

    private ShopAdminFacade shopAdminFacade;

    public CustomerController() {

    }

    @FXML
    void BtnActualizar_Click(ActionEvent event) {
        Customer selected = tblCustomer.getSelectionModel().getSelectedItem();
        if (selected != null) {
            int id = selected.getId();
            String nuevoNombre = TxtNombre.getText();
            String nuevoEmail = TxtEmail.getText();

            Customer actualizado = new Customer(
                    id,
                    nuevoNombre,
                    nuevoEmail,
                    selected.getUser(), // dejamos el mismo user
                    selected.getPaymentMethods() // dejamos los mismos métodos de pago
            );
            shopAdminFacade.updateCustomer(id, actualizado);

            loadCustomerData();
        }
    }

    @FXML
    void onRowClick(MouseEvent event) throws Exception {
        Customer selected = tblCustomer.getSelectionModel().getSelectedItem();
        if (selected != null) {
            int customerId = selected.getId();
            txtIdProduct.setText(String.valueOf(customerId));
            TxtNombre.setText(selected.getName());
            TxtEmail.setText(selected.getEmail());
            List<Order> orders = shopAdminFacade.getOrdersByCustomerId(customerId);

            if (treeViewOrder.getRoot() == null) {
                TreeItem<String> rootItem = new TreeItem<>("Pedidos");
                rootItem.setExpanded(true);
                treeViewOrder.setRoot(rootItem);
            } else {
                // Limpiar los hijos existentes si se desea refrescar la vista
                treeViewOrder.getRoot().getChildren().clear();
            }

            for (Order order : orders) {
                // Crear el nodo principal del TreeView (Pedido)
                TreeItem<String> orderItem = new TreeItem<>("Pedido #" + order.getOrderId());

                // Obtener los productos del pedido
                List<Product> products = new ArrayList<>();
                for (int productId : order.getProductIds()) {
                    Product product = pr.getProduct(productId);
                    if (product != null) {
                        products.add(product);
                    }
                }

                // Agregar productos como nodos hijos del pedido
                for (Product product : products) {
                    TreeItem<String> productItem = new TreeItem<>(product.getName() + " - $" + product.getPrice());
                    orderItem.getChildren().add(productItem);
                }

                // Agregar el nodo del pedido al TreeView
                treeViewOrder.getRoot().getChildren().add(orderItem);
            }

            List<PaymentMethod> methods = shopAdminFacade.getPaymentMethodsByCustomerId(customerId);

            ObservableList<PaymentMethod> observableMethods = FXCollections.observableArrayList(methods);
            
            tablePaymentMethods.setItems(observableMethods);

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources
    ) {

        colMetodo.setCellValueFactory(new PropertyValueFactory<>("type"));
        colStatus.setCellValueFactory(cellData -> {
            boolean isActive = cellData.getValue().isActive(); // o getActive() según tu clase
            String estado = isActive ? "Activado" : "Bloqueado";
            return new ReadOnlyStringWrapper(estado);
        });

        colAccion.setCellFactory(param -> new TableCell<PaymentMethod, Void>() {
            private final Button btn = new Button("Toggle");

            {
                btn.setOnAction(event -> {
                    PaymentMethod paymentMethod = getTableView().getItems().get(getIndex());
                    Customer selectedCustomer = tblCustomer.getSelectionModel().getSelectedItem();
                    if (selectedCustomer != null) {
                        int customerId = selectedCustomer.getId(); // Obtener el customerId
                        // Llamamos al facade con el customerId y el paymentMethodId
                        shopAdminFacade.togglePaymentMethodStatus(customerId, paymentMethod.getId());

                        List<PaymentMethod> updatedMethods = shopAdminFacade.getPaymentMethodsByCustomerId(customerId);
                        ObservableList<PaymentMethod> updatedObservable = FXCollections.observableArrayList(updatedMethods);
                        tablePaymentMethods.setItems(null); // Limpieza opcional
                        tablePaymentMethods.setItems(updatedObservable);// Refrescar para mostrar el nuevo estado
                        tablePaymentMethods.refresh();
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        // if (customerService == null) {
        //     ICustomerRepository customerRepository = new CustomerRepository();
        //     customerRepository.seedData();
        //     customerService = new CustomerService(customerRepository);
        // }
        loadCustomerData();

    }

    public void setShopAdminFacade(ShopAdminFacade shopAdminFacade) {
        this.shopAdminFacade = shopAdminFacade;
    }

    public void loadCustomerData() {
        if (shopAdminFacade == null) {

            ICustomerRepository customerRepository = new CustomerRepository();
            IOrderRepository orderRepository = new OrderRepository();
            IPaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository(); // Supón que esta clase existe

            ICustomerService customerService = new CustomerService(customerRepository);
            IOrderService orderService = new OrderService(orderRepository);
            IPaymentMethodService paymentMethodService = new PaymentMethodService(customerService, paymentMethodRepository); // Supón que esta clase existe

            shopAdminFacade = new ShopAdminFacade(customerService, orderService, paymentMethodService);
        }

        List<Customer> customers = shopAdminFacade.getAllCustomers();
        customerData = FXCollections.observableArrayList(customers);
        tblCustomer.setItems(customerData);
    }

}
