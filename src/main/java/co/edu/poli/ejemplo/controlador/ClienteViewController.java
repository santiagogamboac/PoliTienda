package co.edu.poli.ejemplo.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.poli.ejemplo.modelo.BasicShoppingCart;
import co.edu.poli.ejemplo.modelo.Cliente;
import co.edu.poli.ejemplo.modelo.DiscountDecorator;
import co.edu.poli.ejemplo.modelo.FreeShippingDecorator;
import co.edu.poli.ejemplo.modelo.PointsDecorator;
import co.edu.poli.ejemplo.modelo.ProductoAlimento;
import co.edu.poli.ejemplo.modelo.ProductoElectronico;
import co.edu.poli.ejemplo.modelo.ShoppingCart;
import co.edu.poli.ejemplo.servicio.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ClienteViewController implements Initializable {

    ClienteDAO clienteDAO;
    Boolean edicion = false;
    ProductoElectronico producto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            edicion = false;
            clienteDAO = new ClienteDAO();
            columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

            ObservableList<Cliente> lista = FXCollections.observableArrayList(clienteDAO.readAll());
            tblregistrocliente.setItems(lista);

        } catch (Exception e) {
            // org.controlsfx.control.Notifications.create().title("Error").text("Error al cargar clientes").showError();
        }
    }

    @FXML
    private Button Btn_Tree;
    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btn_Decorator;
    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnactualizar;

    @FXML
    private Button btneliminar;

    @FXML
    private TextArea cloneTextArea;

    @FXML
    private Button btnguardar;

    @FXML
    private TableColumn<Cliente, String> columnId;

    @FXML
    private TableColumn<Cliente, String> columnNombre;

    @FXML
    private TableView<Cliente> tblregistrocliente;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtnombre;

    @FXML
    void GuardarCliente(ActionEvent event) {
        edicion = false;
        txtid.setDisable(false);
        btnactualizar.setStyle("-fx-background-color: gray");
        btnguardar.setStyle("-fx-background-color: blue");
    }

    @FXML
    void ActualizarCliente(ActionEvent event) {
        edicion = true;
        btnactualizar.setStyle("-fx-background-color: blue");
        btnguardar.setStyle("-fx-background-color: gray");
    }

    @FXML
    void EliminarCliente(ActionEvent event) {
        if (txtid.getText().isEmpty()) {
            org.controlsfx.control.Notifications.create().title("Advertencia").text("Ingrese el id del cliente a eliminar").showWarning();
            System.out.println("Por favor ingrese el id del cliente a eliminar");

        } else {
            String msg = clienteDAO.delete(txtid.getText());
            org.controlsfx.control.Notifications.create().title("Atención").text(msg).showWarning();

            ObservableList<Cliente> lista = FXCollections.observableArrayList(clienteDAO.readAll());
            tblregistrocliente.setItems(lista);
        }
    }

    @FXML
    void Btn_Click_Confirmar(ActionEvent event) {

        if (edicion) {
            if (txtid.getText().isEmpty() || txtnombre.getText().isEmpty()) {
                org.controlsfx.control.Notifications.create().title("Advertencia").text("Ingrese todos los datos para poder registrar un cliente").showWarning();
                System.out.println("Por favor ingrese los datos del cliente");
            } else {
                Cliente clienteSeleccionado = tblregistrocliente.getSelectionModel().getSelectedItem();
                clienteSeleccionado.setNombre(txtnombre.getText());
                String msj = clienteDAO.update(txtid.getText(), clienteSeleccionado);
                org.controlsfx.control.Notifications.create().title("Atención").text(msj).show();
                ActualizarVista();
            }
        } else {
            if (txtid.getText().isEmpty() || txtnombre.getText().isEmpty()) {
                org.controlsfx.control.Notifications.create().title("Advertencia").text("Los campos deben estar llenos.").showWarning();
            } else {
                try {
                    Cliente cliente = new Cliente(txtid.getText(), txtnombre.getText());
                    String msj = clienteDAO.create(cliente);
                    org.controlsfx.control.Notifications.create().title("Atención").text(msj).show();
                    ObservableList<Cliente> lista = FXCollections.observableArrayList(clienteDAO.readAll());
                    tblregistrocliente.setItems(lista);
                    Limpiar();
                } catch (Exception e) {
                    org.controlsfx.control.Notifications.create().title("Error").text("Error al guardar cliente").showError();
                }
            }
        }
    }

    @FXML
    void BtnLimpiar_Click(ActionEvent event) {
        Limpiar();
    }

    @FXML
    void btn_Decorator_Click(ActionEvent event) {
        ProductoAlimento p = new ProductoAlimento(null, null, 0, 0);
        ProductoAlimento laptop = new ProductoAlimento("1","Laptop", 1200.0, 0);
        ProductoAlimento headphones = new ProductoAlimento("2","Headphones", 80.0, 0);
        ProductoAlimento mouse = new ProductoAlimento("3","Mouse", 25.0, 0);

        System.out.println("=== SHOPPING CART DECORATOR COMBINATIONS ===\n");

        // Combination 1: Basic cart
        ShoppingCart cart1 = new BasicShoppingCart();
        cart1.addItem(laptop);
        printCartDetails(cart1, "Combination 1: Basic Cart");

        // Combination 2: Cart with discount
        ShoppingCart cart2 = new DiscountDecorator(new BasicShoppingCart(), 10);
        cart2.addItem(laptop);
        printCartDetails(cart2, "Combination 2: Cart with 10% Discount");

        // Combination 3: Cart with free shipping
        ShoppingCart cart3 = new FreeShippingDecorator(new BasicShoppingCart());
        cart3.addItem(laptop);
        printCartDetails(cart3, "Combination 3: Cart with Free Shipping");

        // Combination 4: Cart with points
        PointsDecorator cart4 = new PointsDecorator(new BasicShoppingCart());
        cart4.addItem(laptop);
        printCartDetailsWithPoints(cart4, "Combination 4: Cart with Points");

        // Combination 5: Cart with discount and free shipping
        ShoppingCart cart5 = new FreeShippingDecorator(
                new DiscountDecorator(new BasicShoppingCart(), 10));
        cart5.addItem(laptop);
        printCartDetails(cart5, "Combination 5: Cart with Discount and Free Shipping");

        // Combination 6: Cart with discount, free shipping, and points
        PointsDecorator cart6 = new PointsDecorator(
                new FreeShippingDecorator(
                        new DiscountDecorator(new BasicShoppingCart(), 10)));
        cart6.addItem(laptop);
        printCartDetailsWithPoints(cart6, "Combination 6: Cart with Discount, Free Shipping, and Points");

        // Combination 7: Cart with smaller purchase (to show shipping cost)
        ShoppingCart cart7 = new FreeShippingDecorator(new BasicShoppingCart());
        cart7.addItem(headphones);
        cart7.addItem(mouse);
        printCartDetails(cart7, "Combination 7: Cart with Items Below Free Shipping Threshold");

        // Combination 8: Multiple decorators in different order
        PointsDecorator cart8 = new PointsDecorator(
                new DiscountDecorator(
                        new FreeShippingDecorator(new BasicShoppingCart()), 15));
        cart8.addItem(laptop);
        cart8.addItem(headphones);
        printCartDetailsWithPoints(cart8, "Combination 8: Cart with Free Shipping, then Discount, then Points");

    }

    @FXML
    void Btn_Tree_Click(ActionEvent event) {
        try {
            // Cargar el archivo FXML del TreeView
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/poli/ejemplo/vista/TreeView.fxml"));
            Parent root = fxmlLoader.load();

            // Crear una nueva ventana (Stage)
            Stage stage = new Stage();
            stage.setTitle("Jerarquía de Departamentos y Empleados");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleTableClick(MouseEvent event) {
        edicion = true;
        btnactualizar.setStyle("-fx-background-color: blue");
        btnguardar.setStyle("-fx-background-color: gray");
        txtid.setDisable(true);
        Cliente clienteSeleccionado = tblregistrocliente.getSelectionModel().getSelectedItem();

        if (clienteSeleccionado != null) {
            txtid.setText(String.valueOf(clienteSeleccionado.getId()));
            txtnombre.setText(clienteSeleccionado.getNombre());
        }
    }

    @FXML
    void Btn_ClonarClick(ActionEvent event) {
// Clonar el producto
        producto = new ProductoElectronico("1", "Producto Electronico", 1000, 110);

        ProductoElectronico productoClonado = (ProductoElectronico) producto.clone();
        cloneTextArea.appendText(productoClonado.toString() + "\n\n");
    }

    public void ActualizarVista() {
        ObservableList<Cliente> lista = FXCollections.observableArrayList(clienteDAO.readAll());
        tblregistrocliente.setItems(lista);
        Limpiar();
    }

    public void Limpiar() {
        txtid.setText("");
        txtnombre.setText("");
    }
      private static void printCartDetails(ShoppingCart cart, String title) {
        System.out.println(title);
        System.out.println("Description: " + cart.getDescription());
        System.out.println("Items: " + cart.getItems());
        System.out.println("Total: $" + String.format("%.2f", cart.calculateTotal()));
        System.out.println();
    }
    private static void printCartDetailsWithPoints(PointsDecorator cart, String title) {
        System.out.println(title);
        System.out.println("Description: " + cart.getDescription());
        System.out.println("Items: " + cart.getItems());
        System.out.println("Total: $" + String.format("%.2f", cart.calculateTotal()));
        System.out.println("Points earned: " + cart.calculatePoints());
        System.out.println();
    }
     @FXML
    private Button btn_builder;

    @FXML
    void btn_builder_click(ActionEvent event) {
        try {
            // Cargar el archivo FXML del TreeView
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/poli/ejemplo/vista/BuilderViewController.fxml"));
            Parent root = fxmlLoader.load();
    
            // Crear una nueva ventana (Stage)
            Stage stage = new Stage();
            stage.setTitle("Jerarquía de Departamentos y Empleados");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
